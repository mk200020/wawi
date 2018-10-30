package kasmi.wawi.jsf;

import kasmi.wawi.model.Lagerstand;
import kasmi.wawi.jsf.util.JsfUtil;
import kasmi.wawi.jsf.util.PaginationHelper;
import kasmi.wawi.bean.LagerstandFacade;

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

@Named("lagerstandController")
@SessionScoped
public class LagerstandController implements Serializable {

    private Lagerstand current;
    private DataModel items = null;
    @EJB
    private kasmi.wawi.bean.LagerstandFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public LagerstandController() {
    }

    public Lagerstand getSelected() {
        if (current == null) {
            current = new Lagerstand();
            current.setLagerstandPK(new kasmi.wawi.model.LagerstandPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private LagerstandFacade getFacade() {
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
        current = (Lagerstand) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Lagerstand();
        current.setLagerstandPK(new kasmi.wawi.model.LagerstandPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getLagerstandPK().setLagnr(current.getLager().getLagnr());
            current.getLagerstandPK().setArtnr(current.getArtikel().getArtnr());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("LagerstandCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Lagerstand) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getLagerstandPK().setLagnr(current.getLager().getLagnr());
            current.getLagerstandPK().setArtnr(current.getArtikel().getArtnr());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("LagerstandUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Lagerstand) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("LagerstandDeleted"));
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

    public Lagerstand getLagerstand(kasmi.wawi.model.LagerstandPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Lagerstand.class)
    public static class LagerstandControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LagerstandController controller = (LagerstandController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "lagerstandController");
            return controller.getLagerstand(getKey(value));
        }

        kasmi.wawi.model.LagerstandPK getKey(String value) {
            kasmi.wawi.model.LagerstandPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new kasmi.wawi.model.LagerstandPK();
            key.setArtnr(Integer.parseInt(values[0]));
            key.setLagnr(Short.parseShort(values[1]));
            return key;
        }

        String getStringKey(kasmi.wawi.model.LagerstandPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getArtnr());
            sb.append(SEPARATOR);
            sb.append(value.getLagnr());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Lagerstand) {
                Lagerstand o = (Lagerstand) object;
                return getStringKey(o.getLagerstandPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Lagerstand.class.getName());
            }
        }

    }

}
