from tkinter import *


class MyPaint:
    def __init__(self,root):
        self.COLOR = 'red'
        self.c = Canvas(root, width=750, height=650, bg='black', cursor='hand2')
        self.f = Frame(root, width=150, height=650, bg='white', cursor='arrow')

        self.var = IntVar()

        self.red = Radiobutton(self.f, text='Red', font=('Constantia',20,'bold italic'), value=1, variable=self.var, command=self.brush_color,bg='gray')
        self.green = Radiobutton(self.f, text='Green', font=('Constantia',20,'bold italic'), value=2, variable=self.var, command=self.brush_color,bg='gray')
        self.blue = Radiobutton(self.f, text='Blue', font=('Constantia',20,'bold italic'), value=3, variable=self.var, command=self.brush_color,bg='gray')

        self.red.select()

        self.c.bind('<B1-Motion>', self.draw_pixel)
        self.c.bind('<Button-3>', self.clear_canvas)

        self.red.pack(side=TOP,fill=X)
        self.green.pack(side=TOP,fill=X)
        self.blue.pack(side=TOP,fill=X)

        self.c.pack(side=LEFT)

        self.f.pack(side=LEFT)

    def draw_pixel(self,event):
        x = event.x
        y = event.y
        self.c.create_line(x - 5, y - 5, x, y, x + 5, y + 1, width=3, fill=self.COLOR)

    def clear_canvas(self,event):
        self.c.delete("all")

    def brush_color(self):
        if self.var.get() == 1:
            self.COLOR = 'red'

        if self.var.get() == 2:
            self.COLOR = 'green'

        if self.var.get() == 3:
            self.COLOR = 'blue'


root = Tk()

paint = MyPaint(root)

root.geometry('900x650')

root.title('Paint')

root.mainloop()
