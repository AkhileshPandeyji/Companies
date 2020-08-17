from tkinter import *
from tkinter import filedialog


root = Tk()


class MyMenu:
    def __init__(self,root):
        self.i = 0
        self.root = root
        self.f1 = Frame(self.root,width=900,height=700,bg='darkgray',cursor='question_arrow')
        self.f1.propagate(0)
        self.f1.pack()

        # Text Widget
        # Scrollbar
        self.t = Text(self.f1,width=800,height=600,bg='black',fg='purple',font=('Constantia',15,'bold italic'),wrap=WORD)
        self.scbx = Scrollbar(self.f1, orient=HORIZONTAL, command=self.t.xview)
        self.scby = Scrollbar(self.f1, orient=VERTICAL, command=self.t.yview)
        self.t.configure(xscrollcommand=self.scbx.set)
        self.t.configure(yscrollcommand=self.scby.set)
        self.scbx.pack(fill=X,side=BOTTOM)
        self.scby.pack(fill=Y,side=RIGHT)
        self.t.pack()

        # MenuBar
        self.menubar = Menu(self.root)
        self.root.config(menu=self.menubar)

        # File
        self.filemenu = Menu(self.root,tearoff=0)
        self.filemenu.add_command(label='New',command=self.new_file)
        self.filemenu.add_command(label='Open',command=self.open_file)
        self.filemenu.add_command(label='Save',command=self.save_file)
        self.filemenu.add_separator()
        self.filemenu.add_command(label='Exit',command=quit)

        # Edit

        self.editmenu = Menu(self.root,tearoff=0)
        self.editmenu.add_command(label='Undo',command=self.donothing)
        self.editmenu.add_command(label='Redo',command=self.donothing)
        self.editmenu.add_separator()
        self.editmenu.add_command(label='cut',command=self.donothing)
        self.editmenu.add_command(label='copy', command=self.donothing)
        self.editmenu.add_command(label='paste', command=self.donothing)

        # Menu
        self.menubar.add_cascade(label='File',menu=self.filemenu)
        self.menubar.add_cascade(label='Edit',menu=self.editmenu)

    def donothing(self):
        pass

    def open_file(self):
        filename = filedialog.askopenfilename(parent=root,title='Select File',filetypes=(('Python Files','*.py'),('All Files','*.*')))
        if filename is not None and filename != '':
            file = open(str(filename),'r')
            contents = file.read()
            self.t.insert(1.0,contents)
            self.root.title(filename.split('/')[-1])
            file.close()
        else:
            pass

    def save_file(self):
        filename = filedialog.asksaveasfilename(parent=root,title="Save As",defaultextension='.txt')
        if filename is not None and filename != '':
            file = open(str(filename),'w')
            self.root.title(filename.split('/')[-1])
            contents = self.t.get(1.0,END)
            file.write(contents)
            file.close()
        else:
            pass

    def new_file(self):
        self.t.delete(1.0,END)
        self.i += 1
        self.root.title('Untitled-{}.txt'.format(self.i))
        pass


root.title("Sublime")
ob = MyMenu(root)
root.geometry('900x650')
root.mainloop()