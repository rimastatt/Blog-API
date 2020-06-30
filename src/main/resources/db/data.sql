insert into Themes(name, description, picture) values('Europe', 'Very nice here', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQQqSHfpw2SSa5cl1IsR_y8KPjIKiRFA1OW5uH6fyBkDzxUiv41&usqp=CAU');
insert into Themes(name, description, picture) values('Africa', 'Very nice here', 'https://wallpaperaccess.com/full/362147.jpg');
insert into Themes(name, description, picture) values('North America', 'Very nice here', 'https://elenarts.ch/wp-content/uploads/2017/04/canada_Niagara_falls_from_far_with_blue_cloud_and_buildings_web.jpg');
insert into Themes(name, description, picture) values('South America', 'Very nice here', 'https://cdn.hipwallpaper.com/i/28/15/RZTMSP.jpg');
insert into Themes(name, description, picture) values('Asia', 'Very nice here', 'https://c4.wallpaperflare.com/wallpaper/30/70/460/japan-japan-mountain-mount-fuji-wallpaper-preview.jpg');
insert into Themes(name, description, picture) values('Australia', 'Very nice here', 'https://wallpaperaccess.com/full/889209.png');

insert into Articles(title, file_name, description, text, tag, theme_id) values('Cat','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Mountains', 1);
insert into Articles(title, file_name, description, text, tag, theme_id) values('Dog','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Desert', 1);

insert into Articles(title, file_name, description, text, tag, theme_id) values('Mouse','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Night life', 2);
insert into Articles(title, file_name, description, text, tag, theme_id) values('Rat','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Forest', 2);

insert into Articles(title, file_name, description, text, tag, theme_id) values('Bat','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Sea', 3);
insert into Articles(title, file_name, description, text, tag, theme_id) values('Elephant','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'City', 3);

insert into Articles(title, file_name, description, text, tag, theme_id) values('Amygo','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'City', 4);
insert into Articles(title, file_name, description, text, tag, theme_id) values('Bee','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Desert', 4);

insert into Articles(title, file_name, description, text, tag, theme_id) values('Deer','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Forest', 5);
insert into Articles(title, file_name, description, text, tag, theme_id) values('Bird','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Sea', 5);

insert into Articles(title, file_name, description, text, tag, theme_id) values('Venom','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Mountains', 6);
insert into Articles(title, file_name, description, text, tag, theme_id) values('Snaake','fox.jpg','Ruf ruf ruf', 'Dogs are a very loyal breed blablablablabla', 'Desert', 6);

insert into Trips(article_id, location, price, availability) values(1,'Paris', 599.99, 1);
insert into Trips(article_id, location, price, availability) values(2,'London', 2599.99, 0);
insert into Trips(article_id, location, price, availability) values(2,'Madrid', 1599.99, 1);
