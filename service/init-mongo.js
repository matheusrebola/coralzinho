db = db.getSiblingDB('coralzinho');

db.createUser({
  user: 'appuser',
  pwd: 'apppassword',
  roles: [
    {
      role: 'readWrite',
      db: 'coralzinho'
    }
  ]
});

// Criar índices para performance
db.children.createIndex({ "email": 1 }, { unique: true });
db.children.createIndex({ "cpf": 1 }, { unique: true });
db.users.createIndex({ "email": 1 }, { unique: true });

print("Database coralzinho initialized successfully!");
