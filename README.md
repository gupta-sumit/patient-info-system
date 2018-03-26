# patient-info-system
Patient Information System & Access Management

Assumptions:
1. All users are verified using OAuth. Only token will be passed between APIs to retrieve user information.
2. Validation is not performed due to time constraints.


This system has three components. Each component is microservice.

1. Access Manager: This component manages access control for a resource configured by application like Patient Information System.
				This component manages who has access to what resource. Application while giving data to user has to verify
				with system for access control and shared permissions.

2. Document Management System: For a patient, you have prescription or lab report that user will upload
	in this system. This system manages storage of documents. While retrieving document-storage-service will ask for document id
	and access key for document. It will use access key to determine if user has access to document or not using Access Manager APIs.
	


3. Patient Information System: This component manages patient data and configure access of protected document in access manager.



Basic Flow: (Saving Patient Information)
1. User saves patient basic information (like name, email, mob number, age etc.) while registration.
2. Now, user wants to save prescription for a patient. Prescription will have files and data like (date of visit, doctor information, hospital information)
3. On patient data upload, patient-info-controller will upload document to document-storage-service (Document management System). After upload,
	document-storage-service returns document id for saved document which can be used to retrieve document. Now, service will save data in db and get prescription id.
	After saving prescription, patient-info-controller will call access-manager (Access Management Service) for configuring access for prescription-id.
	In return, it will get accessToken for prescription documents, which can be used to retrieve document along with document id.

4. Now, let's say, some other user fetches information of patient by patient id from Patient Info System.
5. This user will get basic patient information and prescription details(just document Id, accessKey). Initially, user will not have access to document. 
6. User has to call access-manager to put request for "Request for Grant View Permission for Prescription Id" by accessTokenKey.
7. Access Manager in turn can notify user using various channel like email, app.  (This is not implemented)
8. Owner will approve request by request id. Can either reject and approve. On approval, requested user id will be added to accessTokenKey shared user list.









