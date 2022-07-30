import threading
import time
from tkinter import *

janela = Tk()


class aplicativo():
    
    def __init__(self):
        self.janela = janela
        self.interface()
        self.criacao()
        self.janela.mainloop()


    def interface(self):
        self.janela.geometry("400x500")
        self.janela.title("Calculadora SrPinheiro")
        self.janela.resizable(False,False)


    def criacao(self):
        self.numeros = []
        self.numeros.append(Button(self.janela, text = f"{1}", command = lambda: self.acao(self.numeros[0])))
        self.numeros.append(Button(self.janela, text = f"{2}", command = lambda: self.acao(self.numeros[1])))
        self.numeros.append(Button(self.janela, text = f"{3}", command = lambda: self.acao(self.numeros[2])))
        self.numeros.append(Button(self.janela, text = f"{4}", command = lambda: self.acao(self.numeros[3])))
        self.numeros.append(Button(self.janela, text = f"{5}", command = lambda: self.acao(self.numeros[4])))
        self.numeros.append(Button(self.janela, text = f"{6}", command = lambda: self.acao(self.numeros[5])))
        self.numeros.append(Button(self.janela, text = f"{7}", command = lambda: self.acao(self.numeros[6])))
        self.numeros.append(Button(self.janela, text = f"{8}", command = lambda: self.acao(self.numeros[7])))
        self.numeros.append(Button(self.janela, text = f"{9}", command = lambda: self.acao(self.numeros[8])))

        pos_y = 130
        pos_x = 50
        valor = 0
        
        for i in range(0,9):

            if(i % 3 == 0 and (not i == 0)):
                pos_y += 70
                pos_x = 50

            self.numeros[i].place(x = pos_x, y = pos_y, width = 60, height = 60)
            pos_x += 70
            valor +=1

        self.numeros.append(Button(self.janela, text = "0", command = lambda: [self.acao(self.numeros[9])]))
        self.numeros[9].place(x = pos_x - 70 * 2, y = pos_y + 70, width = 60, height = 60)

        pos_y = 130
        pos_x = 50

        self.operacoes = []


        self.operacoes.append(Button(self.janela, text = "+",command= lambda: [self.acao(self.operacoes[0])]))
        self.operacoes.append(Button(self.janela, text = "-",command= lambda: [self.acao(self.operacoes[1])]))
        self.operacoes.append(Button(self.janela, text = "*",command= lambda: [self.acao(self.operacoes[2])]))
        self.operacoes.append(Button(self.janela, text = "÷",command= lambda: [self.acao(self.operacoes[3])]))


        for i in range(0,4):
            self.operacoes[i].place(x = pos_x + 70 * 3, y = pos_y, width = 90, height = 60)
            pos_y += 70
            
          
        self.sinais = []
        self.sinais.append(Button(self.janela, text = "(", command= lambda: [self.acao(self.sinais[0])]))
        self.sinais[0].place(x = 50, y = 130 + 70 *3, width= 60, height = 60)

        self.sinais.append(Button(self.janela, text = "Limpar", command= lambda: [self.acao(self.sinais[1])]))
        self.sinais[1].place(x = 50 + 70 * 2, y = 130 + 70 *3, width= 60, height = 60)

        self.sinais.append(Button(self.janela, text = "Calcular", command= lambda: [self.acao(self.sinais[2])]))
        self.sinais[2].place(x = 50, y = 130 + 70 * 4, width = 300, height = 60)

        self.tela = Label(self.janela)
        self.tela.place(x = 50, y = 15, width = 300, height = 100)
        self.tela.configure(background= "#808080")

        self.formula = Label(self.janela, text = "")
        self.formula.place(x = 50, y = 20, width=300)
        self.formula.configure(background= "#808080")

        self.resultado = Label(self.janela, text = "")
        self.resultado.place(x = 50, y = 100, width=300)
        self.resultado.configure(background= "#808080")

    def acao(self,bot):

        if bot["text"] == "Calcular":
            try:
                self.formula["text"] = f"{ eval(self.formula['text']) }"

            except:
                pass

        elif bot["text"] == "Limpar":
            self.formula["text"] = ""

        else:
            self.formula["text"] += bot["text"]

            if bot["text"] == "(":
                bot["text"] = ")"

            elif bot["text"] == ")":
                bot["text"] = "("

        """    try:
                self.resultado["text"] = f"{ eval(self.formula['text']) }"

            except:
                pass"""
            

    def alt(self):
        if self.sinais[0]["text"] == "(":
            self.sinais[0]["text"] = ")"
        else:
            self.sinais[0] = "("




            
if __name__ == "__main__":
    aplicativo()
