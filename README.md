# RabbitMQ
Spring boot with rabbitMQ,JPA and MYSql

# RabbitMQ Windows Service Setup

This guide helps you set up RabbitMQ as a Windows service so it starts automatically with your system.

## Prerequisites

- RabbitMQ installed (e.g., `C:\Program Files\rabbitmq-server-windows-4.0.8\rabbitmq_server-4.0.8`)
- Erlang installed
- Administrator privileges

## Steps

1. **Open Command Prompt as Administrator**  
   - Search for "cmd" in Start Menu  
   - Right-click → Run as administrator

2. **Navigate to RabbitMQ sbin directory**

   ```cmd
   cd "C:\Program Files\rabbitmq-server-windows-4.0.8\rabbitmq_server-4.0.8\sbin"
   ```

3. **Install RabbitMQ as a service**

   ```cmd
   rabbitmq-service.bat install
   ```

4. **Start the service**

   ```cmd
   rabbitmq-service.bat start
   ```

5. **(Optional) Check status**

   ```cmd
   rabbitmq-service.bat status
   ```

6. **(Optional) Enable Management Plugin**

   ```cmd
   rabbitmq-plugins.bat enable rabbitmq_management
   ```

   Then visit: http://localhost:15672  
   Login with: `guest` / `guest`

---

Once installed as a service, RabbitMQ will automatically start when your system boots.

