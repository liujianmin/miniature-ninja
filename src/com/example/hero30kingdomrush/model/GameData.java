package com.example.hero30kingdomrush.model;

public class GameData {

	public static int SW;//��Ļ��
	public static int SH;//��Ļ��
	
	//��ɫ��������
	public final static byte MAINROLE=0;
	public final static byte NPC=1;
	public final static byte MONSTER=2;
	public final static byte BOX=3;
	public final static byte BOSS=4;
	
	//��ɫ��������
	public final static byte MAN=0;
	public final static byte WOMAN=1;
	public final static byte GIRL=2;
	public final static byte BOY=3;
	public final static byte OLDMAN=4;
	public final static byte OLDWOMAN=5;

	//��ɫ����״̬
	public final static byte ROLE_STAND = 0;//վ��״̬
	public final static byte ROLE_RUN = 1;//�ܶ�״̬
	public final static byte ROLE_ATTACK = 2;//����״̬
	
	//��������
	public final static byte TYPE_HAT = 0; //ñ��
	public final static byte TYPE_ARMOR = 1; //����
	public final static byte TYPE_GLOVE = 2; //����
	public final static byte TYPE_BELT = 3; //����
	public final static byte TYPE_SHOES = 4; //Ь��
	public final static byte TYPE_ACC = 5; //����
	public final static byte TYPE_WEAPON = 6; //����
	public final static byte TYPE_RESTORE = 7; //�ظ���ҩƷ
	public final static byte TYPE_MISSION = 8; //����������
	
//ljm	
/*	public static Image imgHero;
	public static Image[] equipIcon;
	public static Image imgOver;
	public static Image imgFrame0,imgFrame1,imgFrame2;
	
	public static Image[] imgRole; // ��ɫ��ͼƬ����
	public static Image[] imgTile;//������Ԫͼ
	public static Image[] imgFloorTitle;//�ر�Ԫͼ
*/	
	
	// ��ֵ Nokia����
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
	// Ԥ��������
	//public static Font fontSmall;
	//public static Font fontMedium;
	
	// ����߶�
	public static int fontSmallH; 
	public static int fontMediumH; 

	// Ԥ����ê��
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
