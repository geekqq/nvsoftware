This project is a demo online shopping system including the following microservices:
- Product Service
	Create products
	Get products details from database
- Order Service
	Place orders
	Get order details from database
- Payment Service
	Payment details
- Inventory Service
	Reduce inventory quantity when order placed
- Eureka Server
	Services discovery and registry
- Config Service
	Read config file from remote repository
- API Gateway
	Direct all requests to corrosponding route and fall back to default page when failed
- Redis Service
	Add rate limiter when too may requests with 429 error code
