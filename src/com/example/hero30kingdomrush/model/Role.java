package com.example.hero30kingdomrush.model;

public class Role {
	public byte type;// ��ɫ����
	
	public String name;//��ɫ����
	
	public byte gender;//�Ա�����

	public int lev;// �ȼ�

	public int exp;// ����

	public int hp;// ��ǰ����ֵ
	
	public int maxHp;//������ֵ

	public int mp;// ħ��ֵ

	public int ap;// ������
	
	public int def; //������

	public int x;// ��ɫ�������Ļ������

	public int y;

	public int speed;// ����Ĳ���(�ƶ��ٶ�)

	public int roleDir;// ��ɫ����

	public int roleState;// ��ɫ״̬
	

	private int actionNum;// ����������

	private boolean bNoAction;// û�ж���

	private RoleAction[] roleAction;// ��������

	public int actionID;// ��ǰҪ���ŵĶ���ID

	public int drawType;// ��������0Ϊ������ 1Ϊ����

	public int actionType;// ������������ 1Ϊ����1֡ 0Ϊ����һ�� ����Ϊѭ������
	

	public int traceArea = 50;// ��ɫ��׷����Ұ��Χ

	public int attackArea = 25;// ��ɫ�Ĺ�����Ұ

	public int attTime = 1000;// ��ɫ�Ĺ���ʱ����
	
	public int[][] itemFall;//��ɫ�������Ʒ�͸���[i][0]��ƷID [i][1]����
	
	public int maxMoney;//��ɫ��������Ǯ��
	

	private Map map;// ��ɫ���ڵĵ�ͼ�Ķ���

	public Role(Map map) {// ���캯��������Map�����
		this.map = map;// Role��Map�����ָ��ǰ��ͼ
	}

	/**
	 * ���õ�ǰҪ���ŵĶ���
	 * @param id int  ����ID
	 */
	public final void setActionID(int id, int type, int _actionType) {
		if (id >= actionNum) { //�ж��Ƿ�ȡ����û�еĶ���
			bNoAction = true;//û�иö���
			return;
		}
		bNoAction = false;//
		if (id != -1) {//���==-1��ô�Ͳ��ı䶯��ID
			actionID = id;
		}
		if (type != -1) {//���==-1��ô�Ͳ��ı��������
			drawType = type;
		}
		if (_actionType != -1) {//���==-1��ô�Ͳ��ı䶯����������
			actionType = _actionType;
		}
	}
	
	/**
	 * ������һ��Ҫ���ŵĶ���
	 * @param type
	 * @param _actionType
	 */
	public final void nextAction(int type, int _actionType){
		if(++actionID>=actionNum){
			actionID=0;
		}
		
		if (type != -1) {//���==-1��ô�Ͳ��ı��������
			drawType = type;
		}
		if (_actionType != -1) {//���==-1��ô�Ͳ��ı䶯����������
			actionType = _actionType;
		}
	}

	/**
	 * �����ɫ����
	 */
	public final void loadRoleData(DataInputStream din) {
		try {
			din.readInt();
			actionNum = din.readByte(); //��������
			roleAction = new RoleAction[actionNum];
			for (int i = 0; i < actionNum; i++) {
				roleAction[i] = new RoleAction();
				roleAction[i].loadActionData(din); //�����ɫ��������
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * ������ɫ
	 * @param role Role
	 * @param m int
	 * @param n int
	 */
	public final void copyRoll(Role role, int m, int n) {
		actionNum = role.actionNum;//���ƶ�����
		roleAction = new RoleAction[role.actionNum];//������������
		for (int i = 0; i < actionNum; i++) {
			roleAction[i] = new RoleAction();
			roleAction[i].copyAction(role.roleAction[i]);//���ƶ��������
		}

		//��������
		type = role.type;
		name =role.name;
		lev = role.lev;
		exp = role.exp;
		hp = role.hp;
		maxHp = role.maxHp;
		mp = role.mp;
		ap = role.ap;
		def = role.def;

		x = n * 16;//�������ڵ�ͼ����������
		y = m * 16;
		speed = role.speed;
		actionType=role.actionType;
		gender=role.gender;
		itemFall=role.itemFall;
		maxMoney=role.maxMoney;
	}

	/**
	 * ���ƽ�ɫ�ķ���
	 * @param g Graphics
	 */
	public final void drawRole(Graphics g, int offx, int offy) {
		if (roleAction[actionID].drawRoleAction(g, x - offx, y - offy,
				drawType, actionType)) {
			actionType = 1; //�����������һ�� ��ô�����ò��ŷ�ʽΪ���ŵ�һ֡
			roleState = Data.ROLE_STAND;//���ý�ɫ״̬Ϊվ��״̬
		}
	}

	/**
	 * ��ɫ�ƶ�
	 * @param keyCode int ������Ϣ
	 */
	public final void roleMove(int keyCode, int type) {
		if (bNoAction) { //��ȡ��������������ʱ ���ƶ�
			return;
		}
		if (type > 0) { //��һ������ʱ ��¼��ǰ�İ�������
			roleDir = keyCode;
		}
		
		switch (keyCode) {
		case Data.KEY_UP: // �����Ϸ����ʱ
			if (y > 10) { //��ɫ���ϳ�����ͼ�߽�
				y -= speed;
			}
			break;
		case Data.KEY_RIGHT: // �����ҷ����ʱ
			if (x < map.width * map.cellWidth - 10) { //��ɫ���ҳ�����ͼ�߽�
				x += speed;
			}
			break;
		case Data.KEY_DOWN: // �����·����ʱ
			if (y < map.height * map.cellHeight - speed) {
				y += speed;
			}
			break;
		case Data.KEY_LEFT: // ���������ʱ
			if (x > 10) {
				x -= speed;
			}
			break;
		}
	}

	private byte triggerNum;//������ӵ�д����¼���������Ի�������

	private String[] strTrigger;//�����¼�������

	public final void setTriggerNum(byte num) {
		triggerNum = num;
		strTrigger = new String[triggerNum];
	}

	public final byte getTriggerNum() {
		return triggerNum;
	}

	private int tempIndex;

	public final void addTrigger(String str) {
		strTrigger[tempIndex] = str;
		tempIndex++;
	}

	public final String getStrTrigger(int id) {
		if (id >= triggerNum) {
			return null;
		}
		return strTrigger[id];
	}

	public final int[] getHitRect() { //ȡ����ײ����
		return roleAction[actionID].getHitRect();
	}

	public final int[] getAttackRect() { //ȡ�ù�������
		return roleAction[actionID].getAttackRect(drawType);
	}

	public final void setRoleState(int _state) { //���ý�ɫ״̬
		roleState = _state;
	}

	public final void setIX(int x) {//���ý�ɫX��λ��
		this.x = x;
	}

	public final void setIY(int y) {//���ý�ɫy��λ��
		this.y = y;
	}

}
