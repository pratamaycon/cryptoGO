========================
REST API Documentation
========================

The Stashboard REST API is split in two portions. The public facing REST API only responds to GET and lives at the ``/api/v1/`` endpoint. This API requires no authentication.

The admin-only REST API lives at the ``/admin/api/v1/`` endpoint and responsds to GET, POST, PUT, and DELETE. You'll need to authenticate via OAuth. You can obtain your OAuth keys on the OAuth Credentials page at ``https://{application-id}.appspot.com/admin/credentials``

Services 
----------

The Services resource represents all web services currently tracked via Stashboard.

==============   ===============
Property         Description
==============   ===============
id	         The unique identifier by which to identify the service
name             The name of the service, defined by the user
description      The description of the web service
current-event    The current event for the service
url	         The URL of the specific service resource
==============   ===============
