package kasmi.wawi.jsf;

import kasmi.wawi.model.Setartikel;
import kasmi.wawi.jsf.util.JsfUtil;
import kasmi.wawi.jsf.util.PaginationHelper;
import kasmi.wawi.bean.SetartikelFacade;

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

@Named("setartikelController")
@SessionScoped
public class SetartikelController implements Serializable {

    private Setartikel current;
    private DataModel items = null;
    @EJB
    private kasmi.wawi.bean.SetartikelFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public SetartikelController() {
    }

    public Setartikel getSelected() {
        if (current == null) {
            current = new Setartikel();
            current.setSetartikelPK(new kasmi.wawi.model.SetartikelPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private SetartikelFacade getFacade() {
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
        current = (Setartikel) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Setartikel();
        current.setSetartikelPK(new kasmi.wawi.model.SetartikelPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getSetartikelPK().setTeilartnr(current.getArtikel1().getArtnr());
            current.getSetartikelPK().setSetartnr(current.getArtikel().getArtnr());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SetartikelCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Setartikel) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getSetartikelPK().setTeilartnr(current.getArtikel1().getArtnr());
            current.getSetartikelPK().setSetartnr(current.getArtikel().getArtnr());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SetartikelUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Setartikel) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SetartikelDeleted"));
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

    public Setartikel getSetartikel(kasmi.wawi.model.SetartikelPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Setartikel.class)
    public static class SetartikelControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SetartikelController controller = (SetartikelController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "setartikelController");
            return controller.getSetartikel(getKey(value));
        }

        kasmi.wawi.model.SetartikelPK getKey(String value) {
            kasmi.wawi.model.SetartikelPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new kasmi.wawi.model.SetartikelPK();
            key.setSetartnr(Integer.parseInt(values[0]));
            key.setTeilartnr(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(kasmi.wawi.model.SetartikelPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getSetartnr());
            sb.append(SEPARATOR);
            sb.append(value.getTeilartnr());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Setartikel) {
                Setartikel o = (Setartikel) object;
                return getStringKey(o.getSetartikelPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Setartikel.class.getName());
            }
        }

    }

}
