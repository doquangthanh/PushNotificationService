package vn.adata.io.entitys;

public class Message {
	private String body;
	private String icon;
	private String title;
	private String url;

	public Message() {
		super();
	}

	public Message(String body, String icon, String title, String url) {
		super();
		this.body = body;
		this.icon = icon;
		this.title = title;
		this.url = url;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
