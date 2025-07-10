# Verbalia

**Verbalia** is a Java/Spring Boot application that consumes the public [Gutendex API](https://gutendex.com/) to fetch and store information about books and authors. The project integrates data from an external API with local persistence in a PostgreSQL database and provides an interactive menu for data consultation and management.

---

## 🔍 Features

- Search books by title via the Gutendex API and save them in the local database  
- List all registered books  
- List all registered authors  
- List authors alive in a specific year  
- List books filtered by language  
- Delete books  
- Data persistence using Spring Data JPA and PostgreSQL  

---

## 🛠️ Technologies Used

- ☕ **Java 17+**  
- 🌱 **Spring Boot**  
- 🌐 **Spring MVC** (`@RestController`, REST routes)  
- 🗃️ **Spring Data JPA**  
- 🔁 **Hibernate**  
- 🐘 **PostgreSQL**  
- 🌍 **RestTemplate** (to consume the Gutendex API)  
- 📦 **Maven**  

---

## 🚀 Next Steps

- ✅ Improve error handling and user input (CLI and API)  
- ✅ Add unit and integration tests  
- ✅ Replace `RestTemplate` with `WebClient` (more modern)  
- ✅ Implement a web interface (frontend) to improve usability  

---

## 📁 Project Structure

```text
src/
├── controller/        # REST endpoints  
├── service/           # Business logic  
├── repository/        # JPA integration  
├── model/             # JPA entities  
├── client/            # Communication with the Gutendex API  
└── cli/               # Interactive terminal menu  
