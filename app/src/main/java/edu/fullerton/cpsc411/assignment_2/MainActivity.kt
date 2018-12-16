package edu.fullerton.cpsc411.assignment_2

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = MovieDbHelper.getInstance(this)

        // Sample movies added for demo
        // The descriptions and images are from https://en.wikipedia.org/wiki/
        db.insertNewMoive("Bruce Almighty", "Bruce Almighty is a 2003 American " +
                "fantasy comedy film directed by Tom Shadyac and written by Steve Koren, " +
                "Mark O'Keefe and Steve Oedekerk. The film stars Jim Carrey as Bruce Nolan," +
                " a down-on-his-luck TV reporter who complains to God (Morgan Freeman) that" +
                " he is not doing his job correctly, and is offered the chance to try being " +
                "God himself for one week.", "bruce")

        db.insertNewMoive("Harry Potter", "Harry Potter is a series of fantasy novels" +
                " written by British author J. K. Rowling. The novels chronicle the lives of a young" +
                " wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom" +
                " are students at Hogwarts School of Witchcraft and Wizardry. The main story arc " +
                "concerns Harry's struggle against Lord Voldemort, a dark wizard who intends to " +
                "become immortal, overthrow the wizard governing body known as the Ministry of " +
                "Magic, and subjugate all wizards and Muggles (non-magical people).", "harry")

        db.insertNewMoive("The Dark Knight Rise", "The Dark Knight is a 2008 " +
                "superhero film directed, co-produced, and co-written by Christopher Nolan. " +
                "Based on the DC Comics character Batman, the film is the second part " +
                "of Nolan's The Dark Knight Trilogy and a sequel to 2005's Batman Begins, " +
                "starring an ensemble cast including Christian Bale, Michael Caine, Heath" +
                " Ledger, Gary Oldman, Aaron Eckhart, Maggie Gyllenhaal and Morgan Freeman. " +
                "In the film, Bruce Wayne / Batman (Bale), Police Lieutenant James Gordon (Oldman) " +
                "and District Attorney Harvey Dent (Eckhart) form an alliance to dismantle organized" +
                " crime in Gotham City, but are menaced by an anarchist mastermind known as " +
                "the Joker (Ledger), who seeks to undermine Batman's influence and turn the " +
                "city to chaos.", "batman")

        if (savedInstanceState == null) {

            Handler().postDelayed({

                supportFragmentManager.transaction(allowStateLoss = true) {


                    replace(R.id.Fragment_holder, LoginFragment())


                }
            }, 1000)


        }


    }


}























