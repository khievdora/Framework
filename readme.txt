Name: Dora Khiev
ID: #985520

Framework: 
	DB: DBFacade (Facade Pattern)
	Account: AccountHandler and AccountHandlerImpl (Template Method)
	Authentication: AuthenticaitonHandler and AuthenticationHandler (Template Method) 
			Authentication, AuthenticationProxy, and IAuthentication(Prox)
			AuthenticationListener (Observer)
	
	
Application:
	Account: AccountFacade, AccountService (Facade Pattern)
		AccountCareTaker, AccountMemento (Memento Pattern)
	DB: DBFacadeImpl (Facade Pattern), and all implementation of database. 
