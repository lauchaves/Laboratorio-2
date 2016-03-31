package cr.ac.itcr.lab2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private String[] names = {"Laurens","Kevin","Jonathan","Dolger",
    "Joseth","Hellen","Maria","Eder","Brian","Alejandro","Evan","Henry",
    "Efren","Charlie","Jorby","Daryn","Juan","Miguel","Alberto","Eladio","Rafa",
    "Luigi","Oscar","Lorena","Rocio","Diego"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));

        new MyTask().execute();
    }

    //CLASS ASYNCTASK
    class MyTask extends AsyncTask<Void,String,String>
    {

        ArrayAdapter<String> adapter;


        @Override
        protected void onPreExecute() {

            adapter = (ArrayAdapter<String>) listView.getAdapter();

        }

        @Override
        protected String doInBackground(Void... params) {
            /*for (String Name: names){
                publishProgress(Name);*/
            int cont=0;
            int size= names.length;
            for(int a=0;a<=size; a++) {
                String aux[]=names;

                for (int l = 0; l <= 4; l++) {
                    publishProgress(names[l+cont]);
                }
                cont+=5;

                try {
                    //THREAD

                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Todos los nombres fueron agregados satisfactoriamente";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }
    }
}
