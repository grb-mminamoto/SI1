import sqlite3

# Conecta ao banco de dados (cria um novo se não existir)
conn = sqlite3.connect("usuarios.db")
cursor = conn.cursor()

# Cria a tabela se não existir
cursor.execute("CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY, nome TEXT, senha TEXT)")
conn.commit()

# Solicita entrada do usuário
nome = input("Digite seu nome de usuário: ")
senha = input("Digite sua senha: ")

# Vulnerabilidade: Concatenação direta de entrada do usuário na query SQL
query = f"SELECT * FROM usuarios WHERE nome = '{nome}' AND senha = '{senha}'"
cursor.execute(query)

# Verifica se o usuário existe
usuario = cursor.fetchone()
if usuario:
    print("Login bem-sucedido!")
else:
    print("Usuário ou senha inválidos!")

conn.close()
