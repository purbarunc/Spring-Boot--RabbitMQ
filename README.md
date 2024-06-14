# Spring-Boot-RabbitMQ

This is a simple application which demonstrate a message driven loosely coupled application using Rabbit MQ message broker where we are publishing a message to the queue and subsequently receiving the same message without any delay.

**Setting up the Rabbit MQ broker locally:**

1. Start the Rabbit MQ instance using `docker-compose up`
2. Launch the Rabbit MQ Management Console available at http://localhost:15672/
3. By default Username=guest and Password=guest
4. Create a new Queue as below:
   
   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/b29bf812-1a62-499e-98d6-26159bd40cb2)

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/308f303c-f9bf-4bfc-8add-fadbdb473c2c)

5. Create a Topic Exchange as below:

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/ea00c612-3224-48e3-aed2-95b3a7c9761a)

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/8db675cf-db9e-4385-afee-d71584dc8eb4)

6. Bind the above created Queue with the Exchange with some routing key as below:

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/8f727cad-2dfb-4c5c-8998-c297cdaa1063)

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/19aecc4c-7817-4a2b-9b04-a157d435ebeb)

Test Results and Evidence

1. Run both the Publisher and Subscriber application locally in any IDE.
2. Hit the `/order` endpoint from any Rest Client like Insomnia/Postman etc. as below:

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/af2d872c-4618-42db-a6e3-bc2b5bdc704f)

3. If everything is good we should get to see some spike in the Queue at the Manageent Console as below:

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/9aeba592-5ad9-4027-9f84-8f8457867936)

4. We will get the below highlighted log in the Subscriber application instantly as below:

   ![image](https://github.com/purbarunc/Spring-Boot-RabbitMQ/assets/28572738/b59cbd86-ad32-425c-a6cc-cdb90a425139)

5. Both the Message Id in the API Response and in the log is same which denotes message is successfully published and consumed by the downstream system.





