import os

# Solicita entrada do usuário
nome = input("Digite seu nome: ")

# Vulnerabilidade: entrada do usuário sendo concatenada diretamente no comando do sistema
os.system(f"echo Olá, {nome}")
