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

        pos_y = 130
        pos_x = 50

        for i in range(0,9):
            self.numeros.append(Button(self.janela, text = f"{i+1}"))

            if(i % 3 == 0 and (not i == 0)):
                pos_y += 70
                pos_x = 50

            self.numeros[i].place(x = pos_x, y = pos_y, width = 60, height = 60)
            pos_x += 70

        self.numeros.append(Button(self.janela, text = "0"))
        self.numeros[9].place(x = pos_x - 70 * 2, y = pos_y + 70, width = 60, height = 60)

        pos_y = 130
        pos_x = 50

        self.operacoes = []

        for i in range(0,4):
            self.operacoes.append(Button(self.janela))
            self.operacoes[i].place(x = pos_x + 70 * 3, y = pos_y, width = 90, height = 60)
            pos_y += 70
        
        self.operacoes[0]["text"] = "+"
        self.operacoes[1]["text"] = "-"
        self.operacoes[2]["text"] = "*"
        self.operacoes[3]["text"] = "÷"

        self.sinais = Button(self.janela, text = "(")
        self.sinais.place(x = 50, y = 130 + 70 *3, width= 60, height = 60)

        self.limpar = Button(self.janela, text = "Limpar")
        self.limpar.place(x = 50 + 70 * 2, y = 130 + 70 *3, width= 60, height = 60)

        self.calcular = Button(self.janela, text = "Calcular")
        self.calcular.place(x = 50, y = 130 + 70 * 4, width = 300, height = 60)

        self.tela = Label(self.janela)
        self.tela.place(x = 50, y = 15, width = 300, height = 100)
        self.tela.configure(background=	"#808080")

            
if __name__ == "__main__":
    aplicativo()
