from locust import HttpUser, task
import uuid

class HelloWorldUser(HttpUser):
    @task
    def hello_world(self):
        user_id = uuid.uuid4()
        self.client.get("/users/{uuid}?waitTime=100".format(uuid = user_id ))
