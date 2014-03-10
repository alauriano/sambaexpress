package ca.sambaexpress.ui.action;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.richfaces.event.ItemChangeEvent;

@RequestScoped
@ManagedBean
public class PanelMenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String current;

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String updateCurrent(ItemChangeEvent event) {
		setCurrent(event.getNewItemName());
		return current;
	}

}
