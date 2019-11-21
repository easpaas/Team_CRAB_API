# CRAB Apparel Backend

To start the API you will first need to run an instance of postgres in docker
with this command line:

`docker run -d -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password123 --name CRABdb -p 5432:5432 postgres`

Then hit run on the appRunner class and the dataloader should populate the DB you are running on docker.
