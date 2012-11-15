package com.example.hero30kingdomrush.model;

import java.util.Vector;

public class Hero {
	//主角当前状态
	public static String name;//名字
	public static int x,y;//主角坐标
	public static int actionID;// 当前要播放的动作ID
	public static int drawType;// 绘制类型0为不镜像 1为镜像
	public static int actionType;// 动作播放类型 1为播放1帧 0为播放一次 其他为循环播放
	 
	public static int time;
	
	//主角当前属性
	public static int money;
	public static int level;
	public static int exp,maxExp;
	public static int ap;
	public static int armor;
	public static int hp,maxHp;
	public static int mp,maxMp;
	
	//加入装备后的属性
	public static int atk;
	public static int def;
	public static int MaxHp;
	public static int MaxMp;
	
	//主角当前各部位装备ID
	public static int headID;
	public static int armorID;
	public static int gloveID;
	public static int beltID;
	public static int shoesID;
	public static int accID;
	public static int weaponID;
	
	public static Item[] equip; //主角的装备
	public static Vector vItem;//主角背包
	
    public final static void init(){
    	equip=new Item[7]; //主角的装备
		vItem = new Vector();//主角背包
    }
    
    /**
     * 新游戏初始化数据
     */
    public final static void initNew(){
    	name="勇者";
       // x=12*16;
    	//y=6*16;
    	x = 6 * 16;
    	y = 8 * 16;
    	actionID=0;
    	drawType=0;
    	actionType=1;
    	
		//初始化主角装备
		headID=10;
		armorID=11;
		gloveID=12;
		beltID=13;
	    shoesID=14;
		accID=15;
		weaponID=16;
		
		//初始化主角属性
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
