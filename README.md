This project is a demo online shopping system including the following microservices:
- Product Service:
	- Create products
	- Get products details from database
- Order Service:
	- Place orders
	- Get order details from database
- Payment Service:
	- Payment details
- Inventory Service:
	- Reduce inventory quantity when order placed
- Eureka Server:
	- Services discovery and registry 
	
<img src="https://user-images.githubusercontent.com/53326015/236999620-a849740e-9df2-4c39-84a9-e707ea135196.png" alt="image" width="800">

<img src="https://user-images.githubusercontent.com/53326015/237002058-06c3f602-c6ac-4c1d-81b5-2eb28eb8b435.png" alt="image" width="500">

- Config Service:
	- Read config file from remote repository
- API Gateway:
	- Direct all requests to corrosponding route and fall back to default page when failed
- Redis Service:
	- Add rate limiter when too may requests with 429 error code
