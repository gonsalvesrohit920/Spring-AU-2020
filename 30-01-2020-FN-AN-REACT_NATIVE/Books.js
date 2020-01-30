import React from 'react';
import {imagemapper} from './imagemapper';
import {
  SafeAreaView,
  TouchableOpacity,
  FlatList,
  StyleSheet,
  Text,
  Image,
} from 'react-native';

const books_data = {
  //Data
  romance: [
    {
      name: 'Half Girlfriend',
      author: 'Chetan Bhagat',
      image: 'half_girlfriend',
    },

    {
      name: 'More Than Words',
      author: 'Savio Avenicci',
      image: 'more_than_words',
    },
  ],

  thriller: [
    {
      name: 'Inferno',
      author: 'Dan Brown',
      image: 'inferno',
    },

    {
      name: 'If Tomorrow Comes',
      author: 'Sidney Sheldon',
      image: 'if_tomorrow_comes',
    },
  ],

  horror: [
    {
      name: 'The Shining',
      author: 'Stephen King',
      image: 'the_shining',
    },

    {
      name: 'It',
      author: 'Stephen King',
      image: 'it',
    },
  ],
};

// Render Every Book in the view

function Item({id, author, selected, onSelect, image}) {
  return (
    <TouchableOpacity
      onPress={() => onSelect(id)}
      style={[styles.item, {backgroundColor: selected ? 'pink' : 'white'}]}>
      <Text style={styles.author}>Name: {id}</Text>
      <Text style={styles.author}>Author: {author}</Text>
      {selected && <Image style={styles.image} source={imagemapper[image]} />}
    </TouchableOpacity>
  );
}

export default function Books({genre}) {
  const [selected, setSelected] = React.useState(new Map());

  const onSelect = React.useCallback(
    id => {
      const newSelected = new Map(selected);
      newSelected.set(id, !selected.get(id));
      setSelected(newSelected);
    },
    [selected],
  );

  return (
    // Render List of Items
    <SafeAreaView style={styles.container}>
      <FlatList
        data={books_data[genre]}
        renderItem={({item}) => (
          <Item
            id={item.name}
            author={item.author}
            selected={!!selected.get(item.name)}
            onSelect={onSelect}
            image={item.image}
          />
        )}
        keyExtractor={item => item.name} //  Key is the name of the book
        extraData={selected}
      />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: 30,
    borderRadius: 20,
  },
  image: {
    height: 200,
    width: 200,
  },
  item: {
    backgroundColor: '#f9c2ff',
    padding: 20,
    marginVertical: 8,
    marginHorizontal: 16,
    alignItems: 'center',
    justifyContent: 'center',
  },
  horror: {
    color: 'white',
    backgroundColor: 'black',
  },
  author: {
    fontSize: 32,
  },
});
