package com.example.hero30kingdomrush.model;

/**
 * ����
 * @author gb
 * ����ĳһţ��д�ĵ���ϵͳ
 *
 */

public class Item {
	  public String name; //����
	  public String dis; //����
	  public int num=1;//����
	  public int id; //��Ʒ_����ID
	  public byte type; //���ͣ���װ���ģ��������·���ñ�ӣ����Σ�������װ���ģ�ҩ�������ܣ�
	  public byte level; //��Ʒ_���� װ���ȼ���
	  public short price; //��Ʒ�۸����������Ϊ������300����

	  public short addAtt; //���ӵĹ�����
	  public short addDef; //���ӵķ���

	  public short addHp_Max; //���ӵ�HP����
	  public short addMp_Max; //���ӵ�MP����
	  
	  public short addHp; //�ظ���HP
	  public short addMp; //MP�ظ�
	  
	  public final void copyItem(Item item){
		  id=item.id; //��Ʒ_����ID
		  name=item.name; //����
		  dis=item.dis; //����
		  num=item.num;//����
		  type=item.type; //���ͣ���װ���ģ��������·���ñ�ӣ����Σ�������װ���ģ�ҩ�������ܣ�

		  level=item.level; //��Ʒ_���� װ���ȼ���
		  price=item.price; //��Ʒ�۸����������Ϊ������300����

		  addAtt=item.addAtt; //���ӵĹ�����
		  addDef=item.addDef; //���ӵķ���

		  addHp_Max=item.addHp_Max; //���ӵ�HP����
		  addMp_Max=item.addMp_Max; //���ӵ�MP����
		  
		  addHp=item.addHp; //�ظ���HP
		  addMp=item.addMp; //MP�ظ�
	  }

//	  public Item(int ID, String n, String ds, int itemType, int itemprice, int lev,
//	                  int add_att, int add_def,int add_hp_max, int add_hp,
//	                  int add_mp) {
//	    id = (byte) ID;
//	    name = n;
//	    dis = ds;
//	    type = (byte) itemType;
//	    price = (short) itemprice;
//	    level = (byte) lev;
//	    addAtt = (short) add_att;
//	    addDef = (short) add_def;
//	    addHp_Max = (short) add_hp_max;
//	    addHp = (short) add_hp;
//	    addMp = (short) add_mp;
//	  }
}