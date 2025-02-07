# hello_world.py
import subprocess

# Solicita entrada do usuário
user_input = input("Digite seu nome: ")

# Executa um comando no sistema operacional usando a entrada do usuário
command = f"echo Hello, {user_input}"
subprocess.run(command, shell=True)  # Uso inseguro de shell=True com entrada do usuário