create table Employee (empno varchar(30) not null primary key, empname varchar(50), department varchar(30), email varchar(50), phone varchar(20));

Insert into Employee (empno,empname,department,email,phone) values ('E100','Chuck Coordinator','Administration','chuck@colorado.edu','3-1111');
Insert into Employee (empno,empname,department,email,phone) values ('E101','Mary Manager','Football','mary@colorado.edu','5-1111');
Insert into Employee (empno,empname,department,email,phone) values ('E102','Sally Supervisor','Planning','sally@colorado.edu','3-2222');
Insert into Employee (empno,empname,department,email,phone) values ('E103','Alan Administrator','Administration','alan@colorado.edu','3-3333');

Insert into Customer (custno,custname,address,Internal,contact,phone,city,state,zip) values ('C100','Football','Box 352200','Y','Mary Manager','6857100','Boulder','CO','80309');
Insert into Customer (custno,custname,address,Internal,contact,phone,city,state,zip) values ('C101','Men''s Basketball','Box 352400','Y','Sally Supervisor','5431700','Boulder','CO','80309');
Insert into Customer (custno,custname,address,Internal,contact,phone,city,state,zip) values ('C103','Baseball','Box 352020','Y','Bill Baseball','5431234','Boulder','CO','80309');
Insert into Customer (custno,custname,address,Internal,contact,phone,city,state,zip) values ('C104','Women''s Softball','Box 351200','Y','Sue Softball','5434321','Boulder','CO','80309');
Insert into Customer (custno,custname,address,Internal,contact,phone,city,state,zip) values ('C105','High School Football','123 AnyStreet','N','Coach Bob','4441234','Louisville','CO','80027');

Insert into Facility (facno,facname) values ('F100','Football stadium');
Insert into Facility (facno,facname) values ('F101','Basketball arena');
Insert into Facility (facno,facname) values ('F102','Baseball field');
Insert into Facility (facno,facname) values ('F103','Recreation room');

Insert into location (locno,facno,locname) values ('L100','F100','Locker room');
Insert into location (locno,facno,locname) values ('L101','F100','Plaza');
Insert into location (locno,facno,locname) values ('L102','F100','Vehicle gate');
Insert into location (locno,facno,locname) values ('L103','F101','Locker room');
Insert into location (locno,facno,locname) values ('L104','F100','Ticket Booth');
Insert into location (locno,facno,locname) values ('L105','F101','Gate');
Insert into location (locno,facno,locname) values ('L106','F100','Pedestrian gate');



create table Resource_tbl(resno varchar(30), resname varchar(50), rate integer);

Insert into Resource_tbl (resno,resname,rate) values ('R100','attendant',10);
Insert into Resource_tbl (resno,resname,rate) values ('R101','police',15);
Insert into Resource_tbl (resno,resname,rate) values ('R102','usher',10);
Insert into Resource_tbl (resno,resname,rate) values ('R103','nurse',20);
Insert into Resource_tbl (resno,resname,rate) values ('R104','janitor',15);
Insert into Resource_tbl (resno,resname,rate) values ('R105','food service',10);

alter table Resource_tbl
add constraint primary key(resno);

create table EventRequest(eventno varchar(100), dateheld varchar(20),  datereq varchar(20), custno varchar(30), facno varchar(30) , dateauth varchar(30), status varchar(30), estcost varchar(30), estaudience varchar(30), budno varchar(30));

Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E100',str_to_date('25,OCT,18','%d,%b,%y'),str_to_date('06,JUN,18','%d,%b,%y'),'C100','F100',str_to_date('08,JUN,18','%d,%b,%y'),'Approved',5000,80000,'B1000');
Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E101',str_to_date('26,OCT,18','%d,%b,%y'),str_to_date('28,JUL,18','%d,%b,%y'),'C100','F100',null,'Pending',5000,80000,'B1000');
Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E103',str_to_date('21,SEP,18','%d,%b,%y'),str_to_date('28,JUL,18','%d,%b,%y'),'C100','F100',str_to_date('01,AUG,18','%d,%b,%y'),'Approved',5000,80000,'B1000');
Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E102',str_to_date('14,SEP,18','%d,%b,%y'),str_to_date('28,JUL,18','%d,%b,%y'),'C100','F100',str_to_date('31,JUL,18','%d,%b,%y'),'Approved',5000,80000,'B1000');
Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E104',str_to_date('03,DEC,18','%d,%b,%y'),str_to_date('28,JUL,18','%d,%b,%y'),'C101','F101',str_to_date('31,JUL,18','%d,%b,%y'),'Approved',2000,12000,'B1000');
Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E105',str_to_date('05,DEC,18','%d,%b,%y'),str_to_date('28,JUL,18','%d,%b,%y'),'C101','F101',str_to_date('01,AUG,18','%d,%b,%y'),'Approved',2000,10000,'B1000');
Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E106',str_to_date('12,DEC,18','%d,%b,%y'),str_to_date('28,JUL,18','%d,%b,%y'),'C101','F101',str_to_date('31,JUL,18','%d,%b,%y'),'Approved',2000,10000,'B1000');
Insert into EventRequest (eventno,dateheld, datereq,custno,facno,dateauth,status,estcost,estaudience,budno) values ('E107',str_to_date('23,NOV,18','%d,%b,%y'),str_to_date('28,JUL,18','%d,%b,%y'),'C105','F100',str_to_date('31,JUL,18','%d,%b,%y'),'Denied',10000,5000,null);


alter table EventRequest
add constraint primary key(eventno);

alter table EventRequest
add constraint custno_FK foreign key(custno) references Customer(custno), 
add constraint facno_FK foreign key(facno) references Facility(facno);


create table EventPlan(planno varchar(100), eventno varchar(100) , workdate varchar(100), notes varchar(200), activity varchar(200), empno varchar(100) );

Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P100','E100',str_to_date('25,OCT,18','%d,%b,%y'),'Standard operation','Operation','E102');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P101','E104',str_to_date('03,DEC,18','%d,%b,%y'),'Watch for gate crashers','Operation','E100');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P102','E105',str_to_date('05,DEC,18','%d,%b,%y'),'Standard operation','Operation','E102');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P103','E106',str_to_date('12,DEC,18','%d,%b,%y'),'Watch for seat switching','Operation',null);
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P104','E101',str_to_date('26,OCT,18','%d,%b,%y'),'Standard cleanup','Cleanup','E101');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P105','E100',str_to_date('25,OCT,18','%d,%b,%y'),'Light cleanup','Cleanup','E101');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P199','E102',str_to_date('10,DEC,18','%d,%b,%y'),'ABC','Operation','E101');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P299','E101',str_to_date('26,OCT,18','%d,%b,%y'),null,'Operation','E101');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P349','E106',str_to_date('12,DEC,18','%d,%b,%y'),null,'Setup','E101');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P85','E100',str_to_date('25,OCT,18','%d,%b,%y'),'Standard operation','Cleanup','E102');
Insert into EventPlan (planno,eventno,workdate,notes,activity,empno) values ('P95','E101',str_to_date('26,OCT,18','%d,%b,%y'),'Extra security','Cleanup','E102');


alter table EventPlan
add constraint primary key(planno),
add constraint eventno_FK foreign key(eventno) references EventRequest(eventno),
add constraint empno_FK foreign key(empno) references Employee(empno);


create table EventPlanLine(planno varchar(100), lineno varchar(100) , timestart varchar(100), timeend varchar(100), numberfield varchar(100), locno varchar(100) , resno varchar(100) );


Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P100',1, str_to_date('25,OCT,18 8:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'),2,'L100','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P100',2, str_to_date('25,OCT,18 12:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'), 2,'L101','R101');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P100',3, str_to_date('25,OCT,18 7:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,18 16:30:00','%d,%b,%y %H:%i:%s'), 1,'L102','R102');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P100',4, str_to_date('25,OCT,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,18 22:00:00','%d,%b,%y %H:%i:%s'),2,'L100','R102');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P101',1, str_to_date('3,DEC,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('3,DEC,18 20:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P101',2, str_to_date('3,DEC,18 18:30:00','%d,%b,%y %H:%i:%s'),str_to_date('3,DEC,18 19:00:00','%d,%b,%y %H:%i:%s'),4,'L105','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P101',3, str_to_date('3,DEC,18 19:00:00','%d,%b,%y %H:%i:%s'),str_to_date('3,DEC,18 20:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R103');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P102',1, str_to_date('5,DEC,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('5,DEC,18 19:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P102',2, str_to_date('5,DEC,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('5,DEC,18 21:00:00','%d,%b,%y %H:%i:%s'),4,'L105','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P102',3, str_to_date('5,DEC,18 19:00:00','%d,%b,%y %H:%i:%s'),str_to_date('5,DEC,18 22:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R103');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P103',1, str_to_date('12,DEC,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,18 21:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P103',2, str_to_date('12,DEC,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,18 21:00:00','%d,%b,%y %H:%i:%s'),4,'L105','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P103',3, str_to_date('12,DEC,18 19:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,18 22:00:00','%d,%b,%y %H:%i:%s'),2,'L103','R103');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P104',1, str_to_date('26,OCT,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('26,OCT,18 22:00:00','%d,%b,%y %H:%i:%s'),4,'L101','R104');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P104',2, str_to_date('26,OCT,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('26,OCT,18 22:00:00','%d,%b,%y %H:%i:%s'),4,'L100','R104');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P105',1, str_to_date('25,OCT,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,18 22:00:00','%d,%b,%y %H:%i:%s'),4,'L101','R104');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P105',2, str_to_date('25,OCT,18 18:00:00','%d,%b,%y %H:%i:%s'),str_to_date('25,OCT,18 22:00:00','%d,%b,%y %H:%i:%s'),4,'L100','R104');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P199',1, str_to_date('10,DEC,18 8:00:00','%d,%b,%y %H:%i:%s'), str_to_date('10,DEC,18 12:00:00','%d,%b,%y %H:%i:%s'),1,'L100','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P349',1, str_to_date('12,DEC,18 12:00:00','%d,%b,%y %H:%i:%s'),str_to_date('12,DEC,18 15:30:00','%d,%b,%y %H:%i:%s'),1,'L103','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P85',1,  str_to_date('25,OCT,18 9:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'),5,'L100','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P85',2,  str_to_date('25,OCT,18 8:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'),2,'L102','R101');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P85',3, str_to_date('25,OCT,18 10:00:00','%d,%b,%y %H:%i:%s'), str_to_date('25,OCT,18 15:00:00','%d,%b,%y %H:%i:%s'),3,'L104','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P95',1, str_to_date('26,OCT,18 8:00:00','%d,%b,%y %H:%i:%s'),  str_to_date('26,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'),4,'L100','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P95',2, str_to_date('26,OCT,18 9:00:00','%d,%b,%y %H:%i:%s'),  str_to_date('26,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'),4,'L102','R101');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P95',3, str_to_date('26,OCT,18 10:00:00','%d,%b,%y %H:%i:%s'), str_to_date('26,OCT,18 15:00:00','%d,%b,%y %H:%i:%s'),4,'L106','R100');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P95',4, str_to_date('26,OCT,18 13:00:00','%d,%b,%y %H:%i:%s'), str_to_date('26,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'),2,'L100','R103');
Insert into EventPlanLine (planno,lineno,timestart,timeend,numberfield,locno,resno) values ('P95',5, str_to_date('26,OCT,18 13:00:00','%d,%b,%y %H:%i:%s'), str_to_date('26,OCT,18 17:00:00','%d,%b,%y %H:%i:%s'),2,'L101','R104');


alter table EventPlanLine
add constraint primary key(planno, lineno),
add constraint locno_FK foreign key(locno) references location(locno), 
add constraint resno_FK foreign key(resno) references Resource_tbl(resno);


