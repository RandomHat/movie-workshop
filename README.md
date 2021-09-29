# Movie-Workshop

<!--- These are examples. See https://shields.io for others or to customize this set of shields. You might want to include dependencies, project status and licence info here --->
![GitHub repo size](https://img.shields.io/github/repo-size/RandomHat/movie-workshop)
![GitHub contributors](https://img.shields.io/github/contributors/RandomHat/movie-workshop)
![GitHub stars](https://img.shields.io/github/stars/RandomHat/movie-workshop?style=social)
![GitHub forks](https://img.shields.io/github/forks/RandomHat/movie-workshop?style=social)
![Twitter Follow](https://img.shields.io/twitter/RandomHat/movie-workshop?style=social)

Movie-workshop is a little test of the Spring Web and Spring framework that allows anyone interested enough to open a browser window and play with the URL to search up some movie facts.

## Prerequisites

Before you begin, ensure you have met the following requirements:
<!--- These are just example requirements. Add, duplicate or remove as required --->
* You have installed Intellij

or 

* your favourite setup of Java 11, Spring 2.5.5 and Maven 4.0.0.

## Installing Movie-Workshop

To install Movie-Worksop, follow these steps:

Fork the project and open it in your favourite IDE

or

CD to the folder in the terminal.

Buld the project with

```
maven package
```

execute the newly compiled .jar file

```
java -cp target/movie-workshop-0.0.1-SNAPSHOT.jar com.example.movieworkshop.MovieWorkshop
```

## Using Movie-Workshop 

To use Movie-Workshop, follow these steps:

Start the application by following the instructions under installation.

launch a browser and connect to localhost:8080/

check out the features:

endpoints:

```
/getFirst
/getRandom
/getTenSortByPopularity
/howManyWonAnAward
/filter?type="insert letter to search for"&amount="how many times you want the letter or char to appear in the title" eg. /filter?type=u&amount=3
/longest?g1="genre"&g2="other genre" eg. /longest?g1=Drama&g2=Science Fiction

```

## Contributing to Movie-Workshop
<!--- If your README is long or you have some specific process or steps you want contributors to follow, consider creating a separate CONTRIBUTING.md file--->
To contribute to <project_name>, follow these steps:

1. Fork this repository.
2. Create a branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to the original branch: `git push origin <project_name>/<location>`
5. Create the pull request.

Alternatively see the GitHub documentation on [creating a pull request](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## Contributors

Thanks to the following people who have contributed to this project:

* [@RanodmHat](https://www.github.com/RandomHat)
