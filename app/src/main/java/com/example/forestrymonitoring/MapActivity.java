package com.example.forestrymonitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

import java.util.List;


public class MapActivity extends AppCompatActivity {

    public MapView mMapView = null;
    public BaiduMap mBaiduMap = null;
    public LocationClient mLocClient = null;
    public BDLocation location = null;

    public MyLocationListener myLocationListenner = null;
    public BDAbstractLocationListener myListener = new MyLocationListener();

    private Button refresh;

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
        mBaiduMap = mMapView.getMap();//error baiduMap=bull mapView=null
        mBaiduMap.setMyLocationEnabled(true);
        // 设置为一般地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

        //  卫星地图
//        baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

        //空白地图, 基础地图瓦片将不会被渲染。在地图类型中设置为NONE，将不会使用流量下载基础地图瓦片图层。使用场景：与瓦片图层一起使用，节省流量，提升自定义瓦片图下载速度。
//        baiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);


    //设定中心点坐标 西南林业大学坐标
        LatLng cenpt =  new LatLng(25.06056,102.75911);
    //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(12)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate msu = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        // 设置初始大图大小500米MapStatusUpdateFactory
        //MapStatusUpdate
        MapStatusUpdate msu2 = MapStatusUpdateFactory.zoomTo(15.0f);
        //msu = MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);
        mBaiduMap.setMapStatus(msu2);

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