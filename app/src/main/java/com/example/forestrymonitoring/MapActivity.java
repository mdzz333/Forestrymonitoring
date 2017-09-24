package com.example.forestrymonitoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;

public class MapActivity extends AppCompatActivity {

    private MapView mMapView = null;
    private BaiduMap baiduMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);
        init();
    }
    /**
     * 初始化
     */
    private void init(){
        // 初始化控件
        this.initControls();
        // 初始化地图
        this.initMap();
    }

    /**
     * 初始化控件
     */
    private void initControls(){
        // 获取地图视图
        mMapView = (MapView) findViewById(R.id.bmapView);//error mapView=null
    }

    /**
     * 初始化地图
     */
    private void initMap(){
        // 不显示地图上比例尺
//        mapView.showScaleControl(false);
        // 不显示地图缩放控件（按钮控制栏）
//        mapView.showZoomControls(false);
        // 获取百度地图对象
        baiduMap = mMapView.getMap();//error baiduMap=bull mapView=null
        baiduMap.setMyLocationEnabled(true);
        // 设置为一般地图
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

        //  卫星地图
//        baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

        //空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。
//        baiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);

        // 设置初始大图大小500米MapStatusUpdateFactory
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        baiduMap.setMapStatus(msu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}