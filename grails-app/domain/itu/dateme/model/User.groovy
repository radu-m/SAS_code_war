package itu.dateme.model

class User {
	String name
	String address
	String username
	String email
	String password
	Boolean isAdmin	
	
	static scaffold = true
	
    static constraints = {
		
    }
}
