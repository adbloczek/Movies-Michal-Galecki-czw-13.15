package com.michal.galecki.lab2.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static int ALL_SCREENS_NUMBER = 16;
    public static int ALL_ACTORS_NUMBER = 17;
    public static List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    Random random = new Random(System.nanoTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.movies_view);
        moviesAdapter = new MoviesAdapter(movieList);
        LinearLayoutManager moviesLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);
        moviesLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(moviesLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(moviesAdapter);
        prepareMovieData();
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), MovieDetailsViewPager.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                ImageView eyeOfEvidence = (ImageView) view.findViewById(R.id.movieList_imageView_eyeOfEvidence);
                if (eyeOfEvidence.getVisibility() == View.GONE) {
                    eyeOfEvidence.setVisibility(View.VISIBLE);
                } else {
                    eyeOfEvidence.setVisibility(View.GONE);
                }
            }
        }));

        ItemTouchHelper swipeToRemoveTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder targer) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                moviesAdapter.deleteMovie(viewHolder.getAdapterPosition());
            }
        });
        swipeToRemoveTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void prepareMovieData() {
        ArrayList<Integer> allScreensList = getScreensList();
        ArrayList<String> allActorsList = getActorsList();

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure",
                                "2015",
                                "An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and almost everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.",
                                 R.drawable.mad_max_fury_road,
                R.drawable.mad_max_fury_road_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Inside Out",
                "Animation, Kids & Family",
                "2015",
                "Growing up can be a bumpy road, and it's no exception for Riley, who is uprooted from her Midwest life when her father starts a new job in San Francisco. Like all of us, Riley is guided by her emotions - Joy, Fear, Anger, Disgust and Sadness. The emotions live in Headquarters, the control center inside Riley's mind, where they help advise her through everyday life. As Riley and her emotions struggle to adjust to a new life in San Francisco, turmoil ensues in Headquarters. Although Joy, Riley's main and most important emotion, tries to keep things positive, the emotions conflict on how best to navigate a new city, house and school.",
                R.drawable.inside_out,
                R.drawable.inside_out_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action",
                "2015",
                "30 years after the defeat of Darth Vader and the Empire, Rey, a scavenger from the planet Jakku, finds a BB-8 droid that knows the whereabouts of the long lost Luke Skywalker. Rey, as well as a rogue stormtrooper and two smugglers, are thrown into the middle of a battle between the Resistance and the daunting legions of the First Order.",
                R.drawable.star_wars_vii_the_force_awakens,
                R.drawable.star_wars_vii_the_force_awakens_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep",
                "Animation",
                "2015",
                "Shaun the sheep is tired of doing the same work at the farm everyday. He decides to take a day off. In order to do that, he needs to make sure the farmer doesn't know. When more happens than they can handle, the sheep find their way in the big city. Now they need to get back to the farm.",
                R.drawable.shaun_the_sheep,
                R.drawable.shaun_the_sheep_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("The Martian",
                "Science Fiction & Fantasy",
                "2015",
                "During a manned mission to Mars, Astronaut Mark Watney is presumed dead after a fierce storm and left behind by his crew. But Watney has survived and finds himself stranded and alone on the hostile planet. With only meager supplies, he must draw upon his ingenuity, wit and spirit to subsist and find a way to signal to Earth that he is alive. Millions of miles away, NASA and a team of international scientists work tirelessly to bring \"the Martian\" home, while his crewmates concurrently plot a daring, if not impossible, rescue mission. As these stories of incredible bravery unfold, the world comes together to root for Watney's safe return.",
                R.drawable.the_martian,
                R.drawable.the_martian_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation",
                "Action",
                "2015",
                "CIA chief Hunley (Baldwin) convinces a Senate committee to disband the IMF (Impossible Mission Force), of which Ethan Hunt (Cruise) is a key member. Hunley argues that the IMF is too reckless. Now on his own, Hunt goes after a shadowy and deadly rogue organization called the Syndicate.",
                R.drawable.mission_impossible_rogue_nation,
                R.drawable.mission_impossible_rogue_nation_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Up",
                "Animation",
                "2009",
                "Carl Fredricksen as a boy wanted to explore South America and find the forbidden Paradise Falls. About 64 years later he gets to begin his journey along with a Boy Scout named Russel with help from 500 balloons. On their journey they discover many new friends including a talking dog and Carl and Russel figure out that someone evil plans. Carl soon realizes that this evildoer is his childhood idol. Will they be able to defeat him and will they find Paradise Falls?",
                R.drawable.up,
                R.drawable.up_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Star Trek",
                "Science Fiction",
                "2009",
                "On the day of James Kirk's birth, his father dies on his damaged starship in a last stand against a Romulan mining vessel looking for Ambassador Spock, who in this time, has grown on Vulcan disdained by his neighbors for his half-human heritage. 25 years later, James T. Kirk has grown into a young rebellious troublemaker. Challenged by Captain Christopher Pike to realize his potential in Starfleet, he comes to annoy academy instructors like Commander Spock. Suddenly, there is an emergency on Vulcan and the newly-commissioned USS Enterprise is crewed with promising cadets like Nyota Uhura, Hikaru Sulu, Pavel Chekov and even Kirk himself, thanks to Leonard McCoy's medical trickery. Together, this crew will have an adventure in the final frontier where the old legend is altered forever as a new version of the legend begins.",
                R.drawable.star_trek,
                R.drawable.star_trek_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("The LEGO Movie",
                "Animation",
                "2014",
                "The LEGO Movie is a 3D animated film which follows lead character, Emmet a completely ordinary LEGO mini-figure who is identified as the most \"extraordinary person\" and the key to saving the Lego universe. Emmet and his friends go on an epic journey to stop the evil tyrant, Lord Business.",
                R.drawable.the_lego_movie,
                R.drawable.the_lego_movie_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Iron Man",
                "Action & Adventure",
                "2008",
                "Tony Stark. Genius, billionaire, playboy, philanthropist. Son of legendary inventor and weapons contractor Howard Stark. When Tony Stark is assigned to give a weapons presentation to an Iraqi unit led by Lt. Col. James Rhodes, he's given a ride on enemy lines. That ride ends badly when Stark's Humvee that he's riding in is attacked by enemy combatants. He survives - barely - with a chest full of shrapnel and a car battery attached to his heart. In order to survive he comes up with a way to miniaturize the battery and figures out that the battery can power something else. Thus Iron Man is born. He uses the primitive device to escape from the cave in Iraq. Once back home, he then begins work on perfecting the Iron Man suit. But the man who was put in charge of Stark Industries has plans of his own to take over Tony's technology for other matters.",
                R.drawable.iron_man,
                R.drawable.iron_man_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Aliens",
                "Science Fiction",
                "1986",
                "Fifty seven years after Ellen Ripley survived her disastrous ordeal, her escape vessel is recovered after drifting across the galaxy as she slept in cryogenic stasis. Back on Earth, nobody believed her story about the \"Aliens\" on the moon LV-426. After the \"Company\" orders the colony on LV-426 to investigate, however, all communication with the colony is lost. The Company enlists Ripley to aid a team of tough, rugged space marines on a rescue mission to the now partially terraformed moon to find out if there are aliens or survivors. As the mission unfolds, Ripley will be forced to come to grips with her worst nightmare, but even as she does, she finds that the worst is yet to come.",
                R.drawable.aliens,
                R.drawable.aliens_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Chicken Run",
                "Animation",
                "2000",
                "Having been hopelessly repressed and facing eventual certain death at the chicken farm where they are held, Rocky the rooster and Ginger the chicken decide to rebel against the evil Mr. and Ms. Tweedy, the farm's owners. Rocky and Ginger lead their fellow chickens in a great escape from the murderous farmers and their farm of doom.",
                R.drawable.chicken_run,
                R.drawable.chicken_run_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Back to the Future",
                "Science Fiction",
                "1985",
                "Marty McFly, a typical American teenager of the Eighties, is accidentally sent back to 1955 in a plutonium-powered DeLorean \"time machine\" invented by a slightly mad scientist. During his often hysterical, always amazing trip back in time, Marty must make certain his teenage parents-to-be meet and fall in love - so he can get back to the future.",
                R.drawable.back_to_the_future,
                R.drawable.back_to_the_future_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark",
                "Action & Adventure",
                "1981",
                "The year is 1936. An archeology professor named Indiana Jones is venturing in the jungles of South America searching for a golden statue. Unfortunately, he sets off a deadly trap but miraculously escapes. Then, Jones hears from a museum curator named Marcus Brody about a biblical artifact called The Ark of the Covenant, which can hold the key to humanly existence. Jones has to venture to vast places such as Nepal and Egypt to find this artifact. However, he will have to fight his enemy Rene Belloq and a band of Nazis in order to reach it.",
                R.drawable.raiders_of_the_lost_ark,
                R.drawable.raiders_of_the_lost_ark_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Goldfinger",
                "Action & Adventure",
                "1964",
                "Bond is back and his next mission takes him to Fort Knox, where Auric Goldfinger and his henchman are planning to raid Fort Knox and obliterate the world economy. To save the world once again, Bond will need to become friends with Goldfinger, dodge killer hats and avoid Goldfinger's personal pilot, the sexy Pussy Galore. She might not have feelings for Bond, but will 007 help her change her mind?",
                R.drawable.goldfinger,
                R.drawable.goldfinger_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy",
                "Science Fiction & Fantasy",
                "2014",
                "After stealing a mysterious orb in the far reaches of outer space, Peter Quill from Earth, is now the main target of a manhunt led by the villain known as Ronan the Accuser. To help fight Ronan and his team and save the galaxy from his power, Quill creates a team of space heroes known as the \"Guardians of the Galaxy\" to save the world.",
                R.drawable.guardians_of_the_galaxy,
                R.drawable.guardians_of_the_galaxy_tn,
                getRandomScreens(allScreensList),
                getRandomActors(allActorsList));
        movieList.add(movie);

        moviesAdapter.notifyDataSetChanged();
    }

    public ArrayList<Integer> getScreensList() {
        ArrayList<Integer> allScreensList = new ArrayList<>(ALL_SCREENS_NUMBER);

        allScreensList.add(R.drawable.mad_max_fury_road_screen);
        allScreensList.add(R.drawable.inside_out_screen);
        allScreensList.add(R.drawable.star_wars_vii_the_force_awakens_screen);
        allScreensList.add(R.drawable.shaun_the_sheep_screen);
        allScreensList.add(R.drawable.the_martian_screen);
        allScreensList.add(R.drawable.mission_impossible_rogue_nation_screen);
        allScreensList.add(R.drawable.up_screen);
        allScreensList.add(R.drawable.star_trek_screen);
        allScreensList.add(R.drawable.the_lego_movie_screen);
        allScreensList.add(R.drawable.iron_man_screen);
        allScreensList.add(R.drawable.aliens_screen);
        allScreensList.add(R.drawable.chicken_run_screen);
        allScreensList.add(R.drawable.back_to_the_future_screen);
        allScreensList.add(R.drawable.raiders_of_the_lost_ark_screen);
        allScreensList.add(R.drawable.goldfinger_screen);
        allScreensList.add(R.drawable.guardians_of_the_galaxy_screen);

        return allScreensList;
    }

    public ArrayList<Integer> getRandomScreens(ArrayList<Integer> allScreensList) {
        ArrayList<Integer> screensList = new ArrayList<>(allScreensList);
        ArrayList<Integer> result = new ArrayList<>(Movie.SCREENS_NUMBER);
        for (int i = 0; i < Movie.SCREENS_NUMBER; i++) {
            int index = random.nextInt(screensList.size());
            result.add(screensList.get(index));
            screensList.remove(index);
        }
        return result;
    }

    public ArrayList<String> getActorsList() {
        ArrayList<String> allActorsList = new ArrayList<>(ALL_ACTORS_NUMBER);

        allActorsList.add("Jarosław Kaczyński");
        allActorsList.add("Grzegorz Schetyna");
        allActorsList.add("Ryszard Petru");
        allActorsList.add("Władysław Kosiniak-Kamysz");
        allActorsList.add("Jarosław Gowin");
        allActorsList.add("Zbigniew Ziobro");
        allActorsList.add("Elżbieta Bińczycka");
        allActorsList.add("Kornel Morawiecki");
        allActorsList.add("Stanisław Żółtek");
        allActorsList.add("Marek Jurek");
        allActorsList.add("Robert Winnicki");
        allActorsList.add("Bartosz Józwiak");
        allActorsList.add("Aleksandra Popławska");
        allActorsList.add("Małgorzata Romanowicz");
        allActorsList.add("Włodzimierz Czarzasty");
        allActorsList.add("Janusz Korwin-Mikke");
        allActorsList.add("Waldemar Witkowski");

        return allActorsList;
    }

    public ArrayList<String> getRandomActors(ArrayList<String> allActorsList) {
        ArrayList<String> actorsList = new ArrayList<>(allActorsList);
        ArrayList<String> result = new ArrayList<>(Movie.ACTORS_NUMBER);
        for (int i = 0; i < Movie.ACTORS_NUMBER; i++) {
            int index = random.nextInt(actorsList.size());
            result.add(actorsList.get(index));
            actorsList.remove(index);
        }
        return result;
    }
}