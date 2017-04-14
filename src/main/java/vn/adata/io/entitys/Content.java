package vn.adata.io.entitys;

public class Content {

	String topic;
	Object msg;

	public Content() {
		super();
	}

	public Content(String topic, Message msg) {
		super();
		this.topic = topic;
		this.msg = msg;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

}
