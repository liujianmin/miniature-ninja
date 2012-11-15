package com.example.hero30kingdomrush.model;

public class GameData {

	public static int SW;//屏幕宽
	public static int SH;//屏幕高
	
	//角色人物类型
	public final static byte MAINROLE=0;
	public final static byte NPC=1;
	public final static byte MONSTER=2;
	public final static byte BOX=3;
	public final static byte BOSS=4;
	
	//角色人物特征
	public final static byte MAN=0;
	public final static byte WOMAN=1;
	public final static byte GIRL=2;
	public final static byte BOY=3;
	public final static byte OLDMAN=4;
	public final static byte OLDWOMAN=5;

	//角色人物状态
	public final static byte ROLE_STAND = 0;//站立状态
	public final static byte ROLE_RUN = 1;//跑动状态
	public final static byte ROLE_ATTACK = 2;//攻击状态
	
	//道具类型
	public final static byte TYPE_HAT = 0; //帽子
	public final static byte TYPE_ARMOR = 1; //铠甲
	public final static byte TYPE_GLOVE = 2; //手套
	public final static byte TYPE_BELT = 3; //腰带
	public final static byte TYPE_SHOES = 4; //鞋子
	public final static byte TYPE_ACC = 5; //配饰
	public final static byte TYPE_WEAPON = 6; //武器
	public final static byte TYPE_RESTORE = 7; //回复类药品
	public final static byte TYPE_MISSION = 8; //剧情任务类
	
//ljm	
/*	public static Image imgHero;
	public static Image[] equipIcon;
	public static Image imgOver;
	public static Image imgFrame0,imgFrame1,imgFrame2;
	
	public static Image[] imgRole; // 角色的图片数组
	public static Image[] imgTile;//建筑单元图
	public static Image[] imgFloorTitle;//地表单元图
*/	
	
	// 键值 Nokia机型
	public final static int KEY_UP = -1;
	public final static int KEY_DOWN = -2;
	public final static int KEY_LEFT = -3;
	public final static int KEY_RIGHT = -4;
	public final static int KEY_LS = -6;
	public final static int KEY_RS = -7;
	public final static int KEY_OK = -5;
	public final static int KEY_BACK = -11;
	
	public final static int LEFT = 101;
	public final static int RIGHT = 102;

	public final static byte KEY_0 = 48;
	public final static byte KEY_1 = 49;
	public final static byte KEY_2 = 50;
	public final static byte KEY_3 = 51;
	public final static byte KEY_4 = 52;
	public final static byte KEY_5 = 53;
	public final static byte KEY_6 = 54;
	public final static byte KEY_7 = 55;
	public final static byte KEY_8 = 56;
	public final static byte KEY_9 = 57;
	public final static byte KEY_STAR = 42;
	public final static byte KEY_SHARP = 35;
	
	//ljm
	// 预定义字体
	//public static Font fontSmall;
	//public static Font fontMedium;
	
	// 字体高度
	public static int fontSmallH; 
	public static int fontMediumH; 

	// 预定义锚点
	public static int T_L;
	public static int T_R;
	public static int T_H;
	public static int B_L;
	public static int B_R;
	public static int BL_L;
	public static int BL_R;
	public static int BL_H ;
	public static int V_H;
// ljm	
/*	public final static void init(){
		imgHero = Tools.createImage("heroIcon");
		equipIcon = new Image[7];
		for (int i = 0; i < equipIcon.length; i++) {
			equipIcon[i] = Tools.createImage("equip" + i);
		}
		imgOver = Tools.createImage("gameover");
		
		imgFrame0=Tools.createImage("frame0");
		imgFrame1=Tools.createImage("frame1");
		imgFrame2=Tools.createImage("frame2");
	}*/
	
	
}
