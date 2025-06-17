# restora
# 🧠 Restora – Smart Restaurant Management System

**Restora** is an intelligent, modular restaurant management system that blends traditional operations (inventory, menus, tables, orders) with automation and AI-powered recommendations.

## 📌 Project Description

**EN:** Smart restaurant management system with inventory, table control, orders (local/remote), and AI-powered suggestions.  
**ES:** Sistema inteligente para gestión de restaurantes con inventario, mesas, pedidos (locales/remotos) y sugerencias con IA.

---

## 🚀 Features

### ✅ Core Features (MVP)
- JWT-based user authentication (Admin, Waiter, Chef, Customer)
- Real-time inventory tracking and alerts
- Menu and recipe management linked to ingredients
- Table state management (available, occupied, reserved)
- Local (QR/no-login) and remote (login) order registration
- REST API for main entities (users, tables, ingredients, dishes, orders)

### 🤖 Advanced Features (Coming Soon)
- Smart dish recommendations based on preferences, restrictions, and inventory
- Agents that assist chefs/waiters with real-time queries
- Voice/text assistant using LLMs (OpenAI, Claude, etc.)
- Predictive inventory analysis and table assignment

---

## 🧱 Tech Stack (Suggested)

- **Backend:** Node.js / NestJS / Express / Django (choose one)
- **Database:** PostgreSQL / MongoDB
- **Auth:** JWT, Role-based Access Control
- **AI Layer (future):** LangChain, CrewAI, OpenAI API, Python agents
- **API Architecture:** REST (initial) with potential GraphQL extension

---

## 🔐 Roles and Access

| Role       | Capabilities                                |
|------------|---------------------------------------------|
| Admin      | Full access to all features and data        |
| Waiter     | Manage orders and table assignments         |
| Chef       | View incoming orders, manage ingredients    |
| Customer   | Place orders (local or remote)              |

---

## 📦 Main Entities (Data Model)

- `User`: roles, authentication
- `Table`: number, capacity, state
- `Ingredient`: name, stock level, minimum stock
- `Dish`: name, price, recipe
- `Recipe`: links dish and ingredients
- `Order`: state (preparing, served, paid)
- `OrderDetail`: dish + quantity
- `Reservation`: future table allocation

---

## 🛠 Development Phases

### Phase 1 – MVP
- Basic CRUD and REST endpoints
- Auth and role system
- Local/remote order distinction

### Phase 2 – Automation
- Inventory-based dish availability
- Alerts for missing ingredients
- Table assignment automation

### Phase 3 – Internal AI Agents
- Smart queries (e.g., "What’s missing for 3 lasagnas?")
- Operational decision support

### Phase 4 – Conversational Assistant
- LLM integration for natural interactions
- Recommendations, order placement, and queries by voice/text

---

## 🧪 Testing & Quality

- Unit and integration tests
- OpenAPI/Swagger documentation
- Modular architecture (Ports & Adapters recommended)
- Continuous integration 

---


