PGDMP     "                    z            postgres    14.2    14.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    13754    postgres    DATABASE     m   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United Kingdom.1252';
    DROP DATABASE postgres;
                postgres    false                       0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3345                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false                       0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16402    books    TABLE     �   CREATE TABLE public.books (
    isbn integer NOT NULL,
    author character varying,
    soldcopies character varying,
    pages integer,
    idcategory character varying,
    idsubcategory character varying
);
    DROP TABLE public.books;
       public         heap    postgres    false            �            1259    16409    category    TABLE     q   CREATE TABLE public.category (
    idcategory character varying NOT NULL,
    idsubcategory character varying
);
    DROP TABLE public.category;
       public         heap    postgres    false            �            1259    16435    characterandgenre    TABLE     z   CREATE TABLE public.characterandgenre (
    idsubcategory character varying NOT NULL,
    idcategory character varying
);
 %   DROP TABLE public.characterandgenre;
       public         heap    postgres    false            �            1259    16416    customer    TABLE     �   CREATE TABLE public.customer (
    idcustomer character varying NOT NULL,
    address character varying,
    totalsales character varying,
    idorder character varying
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    16423    orders    TABLE     �   CREATE TABLE public.orders (
    idorder character varying NOT NULL,
    isbn integer,
    quantity integer,
    date character varying
);
    DROP TABLE public.orders;
       public         heap    postgres    false                      0    16402    books 
   TABLE DATA           [   COPY public.books (isbn, author, soldcopies, pages, idcategory, idsubcategory) FROM stdin;
    public          postgres    false    210   �                 0    16409    category 
   TABLE DATA           =   COPY public.category (idcategory, idsubcategory) FROM stdin;
    public          postgres    false    211                     0    16435    characterandgenre 
   TABLE DATA           F   COPY public.characterandgenre (idsubcategory, idcategory) FROM stdin;
    public          postgres    false    214   D        	          0    16416    customer 
   TABLE DATA           L   COPY public.customer (idcustomer, address, totalsales, idorder) FROM stdin;
    public          postgres    false    212   o        
          0    16423    orders 
   TABLE DATA           ?   COPY public.orders (idorder, isbn, quantity, date) FROM stdin;
    public          postgres    false    213   �        m           2606    16408    books books_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (isbn);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public            postgres    false    210            o           2606    16415    category category_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (idcategory);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public            postgres    false    211            u           2606    16441 (   characterandgenre characterandgenre_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.characterandgenre
    ADD CONSTRAINT characterandgenre_pkey PRIMARY KEY (idsubcategory);
 R   ALTER TABLE ONLY public.characterandgenre DROP CONSTRAINT characterandgenre_pkey;
       public            postgres    false    214            q           2606    16422    customer customer_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (idcustomer);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    212            s           2606    16429    orders orders_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (idorder);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    213            v           2606    16447    books books_idcategory_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_idcategory_fkey FOREIGN KEY (idcategory) REFERENCES public.category(idcategory);
 E   ALTER TABLE ONLY public.books DROP CONSTRAINT books_idcategory_fkey;
       public          postgres    false    210    3183    211            w           2606    16452    books books_idsubcategory_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_idsubcategory_fkey FOREIGN KEY (idsubcategory) REFERENCES public.characterandgenre(idsubcategory);
 H   ALTER TABLE ONLY public.books DROP CONSTRAINT books_idsubcategory_fkey;
       public          postgres    false    3189    210    214            x           2606    16457 $   category category_idsubcategory_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_idsubcategory_fkey FOREIGN KEY (idsubcategory) REFERENCES public.characterandgenre(idsubcategory);
 N   ALTER TABLE ONLY public.category DROP CONSTRAINT category_idsubcategory_fkey;
       public          postgres    false    3189    214    211            {           2606    16442 3   characterandgenre characterandgenre_idcategory_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.characterandgenre
    ADD CONSTRAINT characterandgenre_idcategory_fkey FOREIGN KEY (idcategory) REFERENCES public.category(idcategory);
 ]   ALTER TABLE ONLY public.characterandgenre DROP CONSTRAINT characterandgenre_idcategory_fkey;
       public          postgres    false    3183    211    214            y           2606    16462    customer customer_idorder_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_idorder_fkey FOREIGN KEY (idorder) REFERENCES public.orders(idorder);
 H   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_idorder_fkey;
       public          postgres    false    212    213    3187            z           2606    16430    orders orders_isbn_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_isbn_fkey FOREIGN KEY (isbn) REFERENCES public.books(isbn);
 A   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_isbn_fkey;
       public          postgres    false    3181    210    213               `   x�3426���/J�T�I���442�460���".C#cS�lq*�!P��Ԁ3)3?�(� ��3#��$�(391�̌�7����2s�i��&�T��qqq 2�*�            x�K��O/J,Ȩ������� <�+            x���,.�/�LN�������� Ex�      	      x�3���/*N�+�44�4����� 7�s      
   "   x�3�4426�44�42�70�7202����� 8�     