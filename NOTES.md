# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

* Based on the requirements, I'm supposing I only need to implement the model and service layer to solve the problem, and that no persistence layer or rest endpoint will be needed.
* I'd generally use Lombok for the entities, equals and hashcode, logging, etc, but since the requirements state no libraries, I've generated them with the IDE.
* The requirements state immutability, so I created the model classes without any setters.
* There are a few warning because of methods being public and packaged accessed only, but considering this is a service that would be expected to be used by another layer, it wouldn't make sense to make it package protected.