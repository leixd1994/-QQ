from flask import Flask,request,Response
import sqlite3
app=Flask(__name__)


conn=sqlite3.connect('freeQQ.db',check_same_thread=False)
c=conn.cursor()
# c.execute('''CREATE TABLE ACCOUNT
#        (
#        id                 INTEGER PRIMARY KEY AUTOINCREMENT,
#        username           TEXT    NOT NULL,
#        password            INT     NOT NULL
#
#         );''')
# conn.commit()

@app.route('/login',methods=['POST'])
def login():
    username = request.form['username']
    password = request.form['password']
    print('收到登陆请求：', username, password)
    resp=Response()
    cursor = c.execute('SELECT username,password from ACCOUNT')
    for i in cursor:
        if i[0]==username:
            if i[1]==password:
                resp.headers['result']='success'
                return resp
            else:
                resp.headers['result']='failed'
                return resp
    resp.headers['result']=='usernotfound'
    return resp

@app.route('/register',methods=['POST'])
def register():
    username=request.form['username']
    password=request.form['password']
    print('收到注册请求：',username,password)
    resp=Response()


    cursor=c.execute('SELECT username from ACCOUNT')
    for i in cursor:
        if i[0]==username:
            resp.headers['result']='failed'
            return resp
    print(('INSERT INTO ACCOUNT VALUES (NULL ,\'%s\',\'%s\')'%(username,password)))
    c.execute('INSERT INTO ACCOUNT VALUES (NULL ,\'%s\',\'%s\')'%(username,password))
    conn.commit()
    resp.headers['result']='success'
    return resp

app.run(threaded=True,host='0.0.0.0')


