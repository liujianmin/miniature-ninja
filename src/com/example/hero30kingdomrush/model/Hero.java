package com.example.hero30kingdomrush.model;

import java.util.Vector;

public class Hero {
	//���ǵ�ǰ״̬
	public static String name;//����
	public static int x,y;//��������
	public static int actionID;// ��ǰҪ���ŵĶ���ID
	public static int drawType;// ��������0Ϊ������ 1Ϊ����
	public static int actionType;// ������������ 1Ϊ����1֡ 0Ϊ����һ�� ����Ϊѭ������
	 
	public static int time;
	
	//���ǵ�ǰ����
	public static int money;
	public static int level;
	public static int exp,maxExp;
	public static int ap;
	public static int armor;
	public static int hp,maxHp;
	public static int mp,maxMp;
	
	//����װ���������
	public static int atk;
	public static int def;
	public static int MaxHp;
	public static int MaxMp;
	
	//���ǵ�ǰ����λװ��ID
	public static int headID;
	public static int armorID;
	public static int gloveID;
	public static int beltID;
	public static int shoesID;
	public static int accID;
	public static int weaponID;
	
	public static Item[] equip; //���ǵ�װ��
	public static Vector vItem;//���Ǳ���
	
    public final static void init(){
    	equip=new Item[7]; //���ǵ�װ��
		vItem = new Vector();//���Ǳ���
    }
    
    /**
     * ����Ϸ��ʼ������
     */
    public final static void initNew(){
    	name="����";
       // x=12*16;
    	//y=6*16;
    	x = 6 * 16;
    	y = 8 * 16;
    	actionID=0;
    	drawType=0;
    	actionType=1;
    	
		//��ʼ������װ��
		headID=10;
		armorID=11;
		gloveID=12;
		beltID=13;
	    shoesID=14;
		accID=15;
		weaponID=16;
		
		//��ʼ����������
		money=100;
		level=1;
		exp=0;
		maxExp=30;
		ap=10;
		armor=5;
		hp=maxHp=50;
		mp=maxMp=100;
		time=3000;		
		
    }
    
    public static void Herover()
    {
    	int a=0,b=0,c=0,d=0;
		for(int i=0;i<Hero.equip.length;i++)
		{
		a+= Hero.equip[i].addAtt;
		b+= Hero.equip[i].addDef;
		c+= Hero.equip[i].addHp_Max;
		d+= Hero.equip[i].addMp_Max; 
		}
		
		atk = ap+a+level-1;
		def = armor+b+level-1;
		MaxHp = maxHp+c+(level-1)*10;
		MaxMp =maxMp+d+level;
		//hp=MaxHp;
		//mp=MaxMp;
		maxExp=level*10+20;
    }
	
}
