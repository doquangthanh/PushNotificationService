package vn.adata.io.entitys;

public class Config {
	String bootstrap_servers;
	String request_required_acks;
	String max_block_ms;
	String block_on_buffer_full;
	String batch_size;

	public String getBootstrap_servers() {
		return bootstrap_servers;
	}

	public void setBootstrap_servers(String bootstrap_servers) {
		this.bootstrap_servers = bootstrap_servers;
	}

	public String getRequest_required_acks() {
		return request_required_acks;
	}

	public void setRequest_required_acks(String request_required_acks) {
		this.request_required_acks = request_required_acks;
	}

	public String getMax_block_ms() {
		return max_block_ms;
	}

	public void setMax_block_ms(String max_block_ms) {
		this.max_block_ms = max_block_ms;
	}

	public String getBlock_on_buffer_full() {
		return block_on_buffer_full;
	}

	public void setBlock_on_buffer_full(String block_on_buffer_full) {
		this.block_on_buffer_full = block_on_buffer_full;
	}

	public String getBatch_size() {
		return batch_size;
	}

	public void setBatch_size(String batch_size) {
		this.batch_size = batch_size;
	}

}
