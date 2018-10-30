package kasmi.wawi.jsf;

import kasmi.wawi.model.Bestellpositionen;
import kasmi.wawi.jsf.util.JsfUtil;
import kasmi.wawi.jsf.util.PaginationHelper;
import kasmi.wawi.bean.BestellpositionenFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("bestellpositionenController")
@SessionScoped
public class BestellpositionenController implements Serializable {

    private Bestellpositionen current;
    private DataModel items = null;
    @EJB
    private kasmi.wawi.bean.BestellpositionenFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public BestellpositionenController() {
    }

    public Bestellpositionen getSelected() {
        if (current == null) {
            current = new Bestellpositionen();
            current.setBestellpositionenPK(new kasmi.wawi.model.BestellpositionenPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private BestellpositionenFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Bestellpositionen) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Bestellpositionen();
        current.setBestellpositionenPK(new kasmi.wawi.model.BestellpositionenPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getBestellpositionenPK().setBestnr(current.getBestellungen().getBestnr());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("BestellpositionenCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Bestellpositionen) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getBestellpositionenPK().setBestnr(current.getBestellungen().getBestnr());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("BestellpositionenUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Bestellpositionen) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("BestellpositionenDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Bestellpositionen getBestellpositionen(kasmi.wawi.model.BestellpositionenPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Bestellpositionen.class)
    public static class BestellpositionenControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BestellpositionenController controller = (BestellpositionenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bestellpositionenController");
            return controller.getBestellpositionen(getKey(value));
        }

        kasmi.wawi.model.BestellpositionenPK getKey(String value) {
            kasmi.wawi.model.BestellpositionenPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new kasmi.wawi.model.BestellpositionenPK();
            key.setBestnr(Integer.parseInt(values[0]));
            key.setPos(Short.parseShort(values[1]));
            return key;
        }

        String getStringKey(kasmi.wawi.model.BestellpositionenPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getBestnr());
            sb.append(SEPARATOR);
            sb.append(value.getPos());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Bestellpositionen) {
                Bestellpositionen o = (Bestellpositionen) object;
                return getStringKey(o.getBestellpositionenPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Bestellpositionen.class.getName());
            }
        }

    }

}
