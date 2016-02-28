<h2> La base de données </h2>

<h4> Les Tables </h4>
  <p>
    Après une bonne lecture du cahier des charges fonctionnel et suite à une bonne analyse, 
    nous nous sommes décidés d'attribuer 5 tables à notre base de données.
    <ul>
      <li> Salle : </li> <span> qui contient les noms de salles </span>
      <li> Etagere : </li> <span> qui contient les numéros des étagères </span>
      <li> Discipline : </li> <span> permet de stocker les noms des différentes disciplines </span>
      <li> SousDiscipline : </li> <span> contient les sous-disciplines </span>
      <li> Cote : </li> <span> Il faut savoir que chaque cote a une racine. Raison pour laquelle nous avons créé un attribut "racine" dans cette table, qui définit quelle est la racine de la cote concernée </span>
    </ul>
  </p>
  <h5>Remarque </h5>
  Certaines tables sont mises à jour, pour contenir l'url de l'image où se trouve la discipline, la sous discipline ou la cote. les tables concernées par les modifications (ajout d'une nouvelle colonne) sont : Cote, Discipline, SousDiscipline.
  
  
<h4> Conception </h4>

<img src="https://github.com/Miage-Paris-Ouest/m1c20152016-planinterbu/blob/master/projet/mcd.jpg"/>
  
    
<h4> Dépendances </h4>
<p>
        <ul>
          <li> Une salle contient au moins une étagère, mais aussi peut en contenir plusieurs. Tandis q'une étagère définie ne peut être que dans une seule salle </li>
          <li> Une salle a plusieurs disciplines dans son enceinte, mais une disciplline ne peut se trouver que dans une salle </li>
          <li> La discipline quant à elle, a plusieurs sous-disciplines mais une sous-discipline reste spécifique qu'à une seule discipline </li>
          <li> La discipline toujours, peut correspondre à plusieurs racines de cote mais une racine de cote ne peut concernée qu'une discipline bien déterminée. </li>
          </ul>
</p>          
 
