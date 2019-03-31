package com.jlearn.Spring.model;

public class PersonV2 {
	
	Name name;
	
	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public static class Name {
		String firstName;

		String lastName;
		
		public Name(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
