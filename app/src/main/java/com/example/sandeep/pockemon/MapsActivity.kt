package com.example.sandeep.pockemon

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        checkpermmison()
        loadpockemon()
    }
var ACCESSLOCATION=123
    fun checkpermmison(){
        if(Build.VERSION.SDK_INT>=23) {

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), ACCESSLOCATION)
                return
            }
        }

            GetUserLocation()
        }


    fun GetUserLocation(){
        Toast.makeText(this,"User Location Access on",Toast.LENGTH_LONG).show()
       var myLocation=MyLocationListener()
       var locationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f,myLocation)

        var mythread=myThread()
        mythread.start()


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

     when(requestCode){
         ACCESSLOCATION->{

             if(grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                 GetUserLocation()
             }else{
                 Toast.makeText(this,"We can not access your Location",Toast.LENGTH_LONG).show()
             }

         }

     }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Greater Noida and move the camera

    }

    var location0:Location?=null

//Get User Location

inner class MyLocationListener:LocationListener {


    constructor(){
        location0=Location("Start")
        location0!!.longitude=0.0
        location0!!.longitude=0.0

    }

    override fun onLocationChanged(location: Location?) {
        location0=location
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(provider: String?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(provider: String?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


 }
var oldLocaton:Location?=null
inner class myThread:Thread{
    constructor():super(){
        oldLocaton=Location("Start")
        oldLocaton!!.longitude=0.0
        oldLocaton!!.longitude=0.0



    }

    override fun run(){
        while (true){
            try {

                if (oldLocaton!!.distanceTo(location0)==0f){

                    continue

                }

                oldLocaton=location0

                runOnUiThread {

                 mMap!!.clear()

                 //it shows my location
                 val NIET = LatLng(location0!!.latitude, location0!!.longitude)
                 mMap.addMarker(MarkerOptions()
                         .position(NIET)
                         .title("Me")
                         .snippet("here is my location")
                         .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))
                 )
                 mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NIET,14f))

                 //it shows pockemon location
                  for (i in 0..listpockemon.size-1){

                      var newpockemon=listpockemon[i]

                      if (newpockemon.IsCatch==false){
                          val pockemonLoc = LatLng(newpockemon.location!!.longitude,newpockemon.location!!.latitude)
                          mMap.addMarker(MarkerOptions()
                                  .position(pockemonLoc)
                                  .title(newpockemon.name!!)
                                  .snippet(newpockemon.des!!+", power:"+ newpockemon!!.power)
                                  .icon(BitmapDescriptorFactory.fromResource(newpockemon.image!!))
                          )

                          if (location0!!.distanceTo(newpockemon.location)<2){

                              newpockemon.IsCatch=true
                              listpockemon[i]=newpockemon
                              playerpower+=newpockemon.power!!
                              Toast.makeText(applicationContext,"You have successfully catched your new pockemon your new power is"
                                      + playerpower, Toast.LENGTH_LONG).show()

                          }


                      }



                  }



             }

                Thread.sleep(1000)
            }catch (ex:Exception){}
        }
    }

  }


    var playerpower=0.0
    var listpockemon=ArrayList<Pockemon>()

    fun loadpockemon(){

        listpockemon.add(Pockemon(R.drawable.pik,"Frog","frog is living in noida ",55.0,28.5355161,77.3910265))
        listpockemon.add(Pockemon(R.drawable.dhil,"dhillon","dhillon is living in meerut ",90.5,28.9844618,77.7064137))
        listpockemon.add(Pockemon(R.drawable.bl,"ball","ball is living in delhi  ",65.5,28.6618976,77.2273958))

    }

}