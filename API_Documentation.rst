========================
REST API Documentation
========================

Usuário
----------

==============   ===============
Property         Description
==============   ===============
codigo	         identificador único
nome             nome do usuário
sobrenome        sobrenome do usuário
login            login do usuário
senha	           senha do usuário
email            email do usuário
==============   ===============

Path Resource
~~~~~~~~~~~~~~~

.. code-block:: text

    /api/v1/users
    
    
GET
+++++

Retorna uma lista de usuários

.. code-block:: bash

   GET /api/v1/users HTTP/1.1

.. code-block:: js

     {
        "users": [
            {
                "codigo": 1,
                "nome": "admin",
                "sobrenome": "Administradores",
                "login": "admin",
                "senha": "$2a$10$/R2EOIyC/WEekC/uKYRyeeY3Zh90mgg0axUc5GK6VKkTPPlrSqxOS",
                "email": "admin@email.com"
            }
        ]
    }
    
GET
+++++

Retorna um usuário pelo Login

.. code-block:: bash

   GET /api/v1/users/{codigo} HTTP/1.1

.. code-block:: js

            {
                "codigo": 1,
                "nome": "admin",
                "sobrenome": "Administradores",
                "login": "admin",
                "senha": "$2a$10$/R2EOIyC/WEekC/uKYRyeeY3Zh90mgg0axUc5GK6VKkTPPlrSqxOS",
                "email": "admin@email.com"
            }
    
POST 
++++++

Cria um usuário

.. code-block:: text

   POST /api/v1/users HTTP/1.1

.. code-block:: js

            {
                "nome": "admin",
                "sobrenome": "Administradores",
                "login": "admin",
                "senha": "123",
                "email": "admin@email.com"
            }

PUT 
++++++

Alterar um usuário

.. code-block:: text

   PUT /api/v1/users/{login} HTTP/1.1

.. code-block:: js


            {
                "nome": "Steven",
                "sobrenome": "Meireles",
                "login": "sten",
                "email": "stenAlves@email.com"
            }

PUT 
++++++

Alterar uma senha

.. code-block:: text

   PUT /api/v1/users/{codigo}/senha HTTP/1.1

.. code-block:: js

   {
    "senhaAtual": "123",
    "novaSenha": "123"
   }
    
DELETE
+++++++

Deleta um usuário

.. code-block:: text

    DELETE /api/v1/users/{login} HTTP/1.1

.. code-block:: js

        {}
