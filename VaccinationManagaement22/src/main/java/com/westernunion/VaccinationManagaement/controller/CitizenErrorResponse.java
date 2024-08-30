package com.westernunion.VaccinationManagaement.controller;

public class CitizenErrorResponse {

	
		// TODO Auto-generated constructor stub
		private int status;
		private String message;
		private long timestamp;
		
		public CitizenErrorResponse(int status, String message, long timestamp) 
		{
			super();
			this.status = status;
			this.message = message;
			this.timestamp = timestamp;
		}

		@Override
		public String toString() {
			return "CitizenErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		

}
