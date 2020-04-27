package beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import model.Teacher;
import service.TeacherService;

 
@ManagedBean(name="dtColumnsView")
@ViewScoped
public class StudentViewTeachersBean implements Serializable {
     
    /**
	 * 
	 */
	private String picture="picture";
	private static final long serialVersionUID = -4834178446185533808L;

	private final static List<String> VALID_COLUMN_KEYS = Arrays.asList("picture", "lastname", "firstname", "email");
     
    private String columnTemplate = "picture lastname firstname email";
     
    private List<ColumnModel> columns;
     
    private List<Teacher> teachers;
     
    private List<Teacher> filteredTeachers;
     
    @ManagedProperty("#{teacherService}")
    private TeacherService service;
 
    @PostConstruct
    public void init() {
    	teachers = service.createTeachers();
         
        createDynamicColumns();
    }
     
    public List<Teacher> getTeachers() {
        return teachers;
    }
 
    public List<Teacher> getFilteredTeachers() {
        return filteredTeachers;
    }
 
    public void setFilteredTeachers(List<Teacher> filteredTeachers) {
        this.filteredTeachers = filteredTeachers;
    }
 
    public void setService(TeacherService service) {
        this.service = service;
    }
 
    public String getColumnTemplate() {
        return columnTemplate;
    }
 
    public void setColumnTemplate(String columnTemplate) {
        this.columnTemplate = columnTemplate;
    }
 
    public List<ColumnModel> getColumns() {
        return columns;
    }
 
    private void createDynamicColumns() {
        String[] columnKeys = columnTemplate.split(" ");
        columns = new ArrayList<ColumnModel>();   
         
        for(String columnKey : columnKeys) {
            String key = columnKey.trim();
             System.out.println(key);
            if(VALID_COLUMN_KEYS.contains(key)) {
                columns.add(new ColumnModel(columnKey.toUpperCase(), columnKey));
                System.out.println(key+" in if");
            }
        }
    }
     
    public void updateColumns() {
        //reset table state
        UIComponent table = FacesContext.getCurrentInstance().getViewRoot().findComponent(":form:teachers");
        table.setValueExpression("sortBy", null);
         
        //update columns
        createDynamicColumns();
    }
     
    static public class ColumnModel implements Serializable {
 
        /**
		 * 
		 */
		private static final long serialVersionUID = 7665681258114680664L;
		private String header;
        private String property;
 
        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }
 
        public String getHeader() {
            return header;
        }
 
        public String getProperty() {
            return property;
        }
    }
}