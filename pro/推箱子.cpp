#include<bits/stdc++.h> 
#include <iostream>
using namespace std;

const int maxn = 10;
	//移动 
const int dx[] = {-1,1,0,0};
const int dy[] = {0,0,-1,1};

struct Node
{
    int x,y,step;
    //结构体直接赋值 
    Node(int x,int y,int step = -1): 
	x(x), y(y), step(step) {}
};
//分别是行列，箱子起点，箱子终点，以及 面积 
int n,m,sx,sy,ex,ey,tmp[maxn][maxn];
//存储要走多少步 
int dist[maxn][maxn][4],px,py;

bool vis[maxn][maxn];


bool bfs1(int x1,int y1,int x2,int y2)
{
	//地图上是否可以移动的位置 
    if(tmp[x1][y1] != 0 || tmp[x2][y2] != 0) return false;
    queue<int> qx,qy;
    //人移动箱子前的位子，和箱子要移动过去的位置 
    qx.push(x1);
    qy.push(y1);
    
    memset(vis,0,sizeof(vis));
    vis[x1][y1] = true;
    
    while(!qx.empty())
    {
    	//临时变量存储人的坐标 
        int x = qx.front(), y = qy.front();
        qx.pop();
        qy.pop();
        //人不用移动就可以移动箱子了
        if(x == x2 && y == y2) return true;
        
        for(int i = 0; i < 4; i++)
        {
        	//分别走四个方向 
            int nx = x + dx[i], ny = y + dy[i];
            //判断是否重复走过，以及地图要走的路是不是空地 
            if(!vis[nx][ny] && tmp[nx][ny] == 0)
            {
                qx.push(nx);
                qy.push(ny);
                vis[nx][ny] = true;
            }
        }
    }
    return false;
}

int bfs()
{
    queue<Node> box,man;
    // 将人箱代入
    box.push(Node(sx,sy,0));
    man.push(Node(px,py));
    
    for(int i = 0; i < 4; i++)
	 dist[sx][sy][i] = -1;
	 
    int x,y,nx,ny,xp,yp,nxp,nyp,pre;
    
    while(!box.empty())
    {
    	//带入人箱位置 
        Node nowbox = box.front(), nowman = man.front();
        box.pop();
        man.pop();
        //箱子位置 
        x = nowbox.x;
        y = nowbox.y;
        pre = nowbox.step;
        //人的位置 
        xp = nowman.x;
        yp = nowman.y;
       					 //printf("box: %d %d  man: %d %d time: %d\n",x,y,xp,yp,dist[x][y][pre]);
        
		if(x == ex && y == ey) 
		return dist[x][y][pre] + 1;
		
        for(int i = 0; i < 4; i++)
        {
        	//箱子和人移动 
            nx = x + dx[i];
            ny = y + dy[i]; 
            nxp = x - dx[i];
            nyp = y - dy[i];
            //人不能穿箱子 
            tmp[x][y] = 1;
            //判断是不是箱子一开始的位置，或者箱子移动后的步数大于等于没移动前的步数+1
            //判断是否有走回头路
            if((dist[nx][ny][i] == -1 || dist[nx][ny][i] >= dist[x][y][pre] + 1)
                    && tmp[nx][ny] == 0//这条路能走 
                    && bfs1(xp,yp,nxp,nyp)) //判断人能不能到这个位置 
            {
                dist[nx][ny][i] = dist[x][y][pre] + 1;
                //把移动到的箱子和人位置打进去
                box.push(Node(nx,ny,i));
                man.push(Node(x,y));
            }
            //立刻将箱子占用的位置置空
            tmp[x][y] = 0;
        }
    }
    return -1;
}

int main()
{
	 //输入数据数量 
    int T;
    scanf("%d",&T);
    while(T--)
    {
    	//房间大小 
        scanf("%d%d",&n,&m);
        //数组置-1 
        memset(dist,-1,sizeof(dist));
        memset(tmp,10,sizeof(tmp));
        
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                scanf("%d",&tmp[i][j]);
                if(tmp[i][j] == 2)//箱子起点
                {
                    sx = i;
                    sy = j;
                }
                if(tmp[i][j] == 3)//箱子终点
                {
                    ex = i;
                    ey = j;
                }
                if(tmp[i][j] == 4)//搬运工位置
                {
                    px = i;
                    py = j;
                }
                if(tmp[i][j] != 1) tmp[i][j] = 0;
                //一种是能站人的，一种是不能站人的 
            }
        }
        printf("%d\n",bfs());
    }
    return 0;
}