# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

* Based on the requirements, I'm supposing I only need to implement the model and service layer to solve the problem, and that no persistence layer or rest endpoint will be needed.
* I'd generally use Lombok for the entities, logging, etc, but since the requirements state no libraries, I'll do getters and constructor myself.
* The requirements state immutability, so I created the model classes without any setters.