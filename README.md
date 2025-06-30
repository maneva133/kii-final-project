# 🏨 Hotel Management System

This is a Hotel Management System web application deployed using containerized microservices and modern DevOps practices. The goal of this project is to demonstrate the full DevOps lifecycle including Dockerization, orchestration with Docker Compose and Kubernetes, CI/CD pipelines, and secure, scalable deployment strategies.

---

## ✅ Project Features

### 📁 1. Public Git Repository 
The entire project is hosted on a public Git repository for version control and collaboration.


---

### 🐳 2. Dockerized the Application 
The backend application is containerized using a custom `Dockerfile`, which allows it to run in any environment that supports Docker.

- Created a lightweight image optimized for deployment.
- Defined build context and dependencies.
- Exposed necessary ports for communication.

---

### 🧱 3. Docker Compose Orchestration 
The application and database are orchestrated together using **Docker Compose** for local development and testing.

- Defined multi-service setup in `docker-compose.yaml`.
- Linked the backend container with a PostgreSQL database container.
- Used environment variables and volumes for configuration and persistence.

---

### 🔄 4. Continuous Integration / Continuous Deployment (CI/CD) 
A complete CI/CD pipeline has been configured using **GitHub Actions**:

- On each push to `main`, the pipeline:
  - Builds the Docker image
  - Tags and pushes it to DockerHub

> 🛠 Tools: GitHub Actions, DockerHub, Kubernetes

---

### ☸️ 5. Kubernetes Manifests

#### 📦 Deployment + ConfigMaps/Secrets 
Created a `Deployment` manifest for the backend application with:

- A `ConfigMap` for non-sensitive environment variables
- A `Secret` for sensitive credentials (e.g., database password)

#### 🌐 Service for Application 
Exposed the backend app within the cluster using a **Kubernetes Service** of type `ClusterIP`.

#### 🚪 Ingress Resource 
Configured an **Ingress** to route external traffic to the service:

- Supports HTTP(S)
- Configured with host-based routing
- Secured with TLS (if applicable)


#### 🧪 Namespace Isolation 
All Kubernetes manifests are deployed within a **dedicated namespace** called `hotel-app`:

- Isolates resources from other workloads
- Enhances organization and security

---


## 📦 Technologies Used

- **Docker & Docker Compose**
- **Kubernetes**
- **GitHub Actions**
- **DockerHub**
- **PostgreSQL**
- **Ingress-NGINX**

---

## 📸 Demo
Countries page url routing (hotel-app.local/countries)
![image](https://github.com/user-attachments/assets/72b7c550-5382-47fe-9015-c4240b97acd9)

---

## 🔐 Secrets & Security

- All sensitive data (e.g., DB credentials) is managed via **Kubernetes Secrets**
- Non-sensitive config stored in **ConfigMaps**
- Secure image builds and deployment steps through CI/CD

---

## 🚀 Deployment Steps (Basic)

1. Clone the repo:
   ```bash
   git clone https://github.com/maneva133/hotel-management-system.git

2. docker-compose up --build
3. kubectl apply -f k8s/ -n hotel-app



